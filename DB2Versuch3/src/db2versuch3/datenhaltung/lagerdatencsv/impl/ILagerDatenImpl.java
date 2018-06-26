package db2versuch3.datenhaltung.lagerdatencsv.impl;

import java.io.FileWriter;
import java.io.PrintWriter;
import db2versuch3.datenhaltung.lagerdatencsv.service.ILagerDaten;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Klasse ILagerVerwaltungImpl - Implementiert alle Methoden der
 * Schnittstellenklasse ILagerVerwaltungImpl. Bietet nach aussen die Erzeugung
 * von CSV-Dateien (konkret Lager.csv) an
 *
 */
public class ILagerDatenImpl implements ILagerDaten {

    private Connection connection;

    public ILagerDatenImpl() {
    }

    public void setConnection(Connection connection) {
        if (connection != null) {
            this.connection = connection;
        }
    }

    /**
     * Methode lagerToCSV - erzeugt aus der LagerTa Tabelle eine Lager.csv-Datei
     */
    @Override
    public void lagertToCSV() throws Exception {
        if (connection != null) {
            ResultSet rs = null;

            try {
                Statement stm = connection.createStatement();

                String sql = "SELECT LA.LNR, LA.LORT, LA.LPLZ FROM LAGERAT LA";
                rs = stm.executeQuery(sql);

                PrintWriter pw = new PrintWriter(new FileWriter("Lager.csv"), true);

                String[] metaData = new String[]{"LNR", "LORT", "LPLZ", "ANZART"};

                int i;
                for (i = 0; i < metaData.length - 1; i++) {
                    pw.print("\"" + metaData[i] + "\";");
                }
                pw.println("\"" + metaData[i] + "\"");

                for (i = 0; rs.next(); i++) {
                    int lnr = rs.getInt("LNR");
                    String lort = rs.getString("LORT");
                    String lplz = rs.getString("LPLZ");

                    sql = "SELECT COUNT(*) ANZART FROM TABLE(SELECT ARTIKELLISTE ";
                    sql += "FROM LAGERAT LA WHERE LA.LNR = " + lnr + ")";
                    Statement stm2 = connection.createStatement();
                    ResultSet rs2 = stm2.executeQuery(sql);
                    
                    int anzart = 0;
                    if(rs2.next()) {
                        anzart = rs2.getInt("ANZART");
                    }
                    
                    pw.print(lnr + ";");
                    pw.print(lort + ";");
                    pw.print(lplz + ";");
                    pw.println(anzart + "");
                    
                    rs2.close();
                    stm2.close();
                }

                if (i == 0) {
                    pw.println("Keine Datensätze verfügbar!");
                }

                rs.close();
                stm.close();

            } catch (Exception e) {
                File lagerFile = new File("Lager.csv");
                if (lagerFile.exists()) {
                    lagerFile.delete();
                }
                throw new Exception(e);
            }
        }
    }
}
