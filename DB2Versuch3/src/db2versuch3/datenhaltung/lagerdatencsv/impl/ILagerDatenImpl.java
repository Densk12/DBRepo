package db2versuch3.datenhaltung.lagerdatencsv.impl;

import db2versuch3.datenhaltung.oracledb.entities.Lager;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import db2versuch3.datenhaltung.lagerdatencsv.service.ILagerDaten;

/**
 * Klasse ILagerVerwaltungImpl - Implementiert alle Methoden der
 * Schnittstellenklasse ILagerVerwaltungImpl. Bietet nach aussen die Erzeugung
 * von CSV-Dateien (konkret Lager.csv) an
 *
 */
public class ILagerDatenImpl implements ILagerDaten {

    /**
     * Methode lagerToCSV - erzeugt aus der gegebenen Liste eine Lager.csv-Datei
     *
     * @param lagerListe List<Lager> - Abbildung der Tabelle LagerTa
     * @return boolean
     */
    @Override
    public boolean lagertToCSV(List<Lager> lagerListe) {
        boolean ret = false;

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("Lager.csv"), true);

        } catch (IOException e) {
            String error = "\n\tFehler! Es konnte keine Lager.csv Datei";
            error += "erstellt werden\n\t" + e.toString();
            System.err.println(error);
            System.exit(-1);
        }

        String[] metaData = new String[]{"LNR", "LORT", "LPLZ", "ANZART"};

        int i;
        for (i = 0; i < metaData.length - 1; i++) {
            pw.print("\"" + metaData[i] + "\";");
        }
        pw.println("\"" + metaData[i] + "\"");

        if (lagerListe != null && lagerListe.size() > 0) {
            for (i = 0; i < lagerListe.size(); i++) {
                pw.print(lagerListe.get(i).getLnr()+";");
                pw.print(lagerListe.get(i).getLort()+";");
                pw.print(lagerListe.get(i).getLplz()+";");
                pw.println(lagerListe.get(i).getAnzart()+"");
            }
            
            ret = true;
        } else {
            pw.println("Keine Datensätze verfügbar!");
        }

        return ret;
    }

}
