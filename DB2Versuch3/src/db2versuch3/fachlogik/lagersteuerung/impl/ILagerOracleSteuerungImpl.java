package db2versuch3.fachlogik.lagersteuerung.impl;

import db2versuch3.datenhaltung.lagerdaten.impl.ILagerCSVImpl;
import db2versuch3.datenhaltung.lagerdaten.impl.ILagerSQLImpl;
import db2versuch3.datenhaltung.lagerdaten.service.ILagerCSV;
import db2versuch3.datenhaltung.lagerdaten.service.ILagerSQL;
import db2versuch3.datenhaltung.oracledb.entities.Lager;
import db2versuch3.datenhaltung.oracledb.impl.IDatabaseImpl;
import db2versuch3.datenhaltung.oracledb.services.IDatabase;
import db2versuch3.fachlogik.lagersteuerung.services.ILagerOracleSteuerung;
import java.sql.Connection;
import java.util.List;

/**
 * Steuerungsklasse ILagerOracleSteuerungImpl Implementiert alle Methoden der
 * Schnittstellenklasse ILagerOracleSteuerung. Bietet nach aussen die Erzeugung
 * von CSV-Dateien (konkret Lager.csv aus der Oracle-DB) an (unter der
 * Verwendung der Datenhaltung)
 *
 * @version 1.0
 */
public class ILagerOracleSteuerungImpl implements ILagerOracleSteuerung {

    /**
     * Methode lagerCSVErstellen - veranlasst die Erzeugung der Lager.csv-Datei
     *
     */
    @Override
    public boolean lagerCSVErstellen() throws Exception {
        
        boolean ret = false;

        String filename = "Lager.csv";

        IDatabase db = new IDatabaseImpl();
        Connection connection = db.getConnection();

        ILagerSQL iLagerSql = new ILagerSQLImpl();
        iLagerSql.setConnection(connection);
        
        List<Lager> lagerListe = iLagerSql.getAlleLager();

        if (lagerListe != null && lagerListe.size() > 0) {
            
            ILagerCSV iLager = new ILagerCSVImpl();
            iLager.setFilename(filename);

            String[] spalten = new String[]{"LNR", "LORT", "LPLZ", "ANZART"};
            ret = iLager.lagerToCSV(spalten, lagerListe);      
            
        }
        
        return ret;
        
    }

}
