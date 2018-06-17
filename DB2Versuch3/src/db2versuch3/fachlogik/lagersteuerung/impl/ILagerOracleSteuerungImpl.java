package db2versuch3.fachlogik.lagersteuerung.impl;

import db2versuch3.datenhaltung.lagerdatencsv.impl.ILagerDatenImpl;
import db2versuch3.datenhaltung.lagerdatencsv.service.ILagerDaten;
import db2versuch3.datenhaltung.oracledb.impl.IDatabaseImpl;
import db2versuch3.datenhaltung.oracledb.services.IDatabase;
import db2versuch3.fachlogik.lagersteuerung.services.ILagerOracleSteuerung;
import java.sql.Connection;

/**
 * Steuerungsklasse ILagerOracleSteuerungImpl Implementiert alle Methoden der
 * Schnittstellenklasse ILagerOracleSteuerung. Bietet nach aussen die Erzeugung
 * von CSV-Dateien (konkret Lager.csv aus der Oracle-DB) an (unter der Verwendung der Datenhaltung)
 * 
 * @version 1.0
 */
public class ILagerOracleSteuerungImpl implements ILagerOracleSteuerung {

     /**
     * Methode lagerCSVErstellen - veranlasst die Erzeugung der Lager.csv-Datei
     *
     */
    @Override
    public void lagerCSVErstellen() throws Exception {
        IDatabase database = new IDatabaseImpl();
        Connection connection = database.getConnection();
        
        ILagerDaten lagerDaten = new ILagerDatenImpl();
        
        lagerDaten.setConnection(connection);
        lagerDaten.lagertToCSV();
    }
    
}
