package db2versuch3.datenhaltung.csv;

import db2versuch3.extern.gateway.jdbc.JDBC;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CSV {

    private JDBC jdbc;

    public CSV() {
    }
    
    public void setJDBC(JDBC jdbc) {
        if(jdbc != null) {
            this.jdbc = jdbc;
        }
    }

    private boolean createCSV(File path, ResultSet rs) {
        boolean ret = false;

        if (path != null) {
            try {
                ResultSetMetaData rsmd = rs.getMetaData();

                PrintWriter pw = null;
                try {
                    pw = new PrintWriter(new FileWriter(path), true);

                } catch (IOException e) {
                    String error = "\n\t\"Fehler! Die Datei: " + path.getName();
                    error += " konnte nicht erstellt werden \n\t" + e.toString();
                    System.err.println(error);
                }

                int i;
                for (i = 0; i < rsmd.getColumnCount(); i++) {
                    String spalte = "\"" + rsmd.getColumnName(i) + "\"";
                    pw.print(spalte);
                }
                pw.println();

                for (i = 0; rs.next(); i++) {
                    String spaltenwert = rs.getString(i);
                    if (spaltenwert == null) {
                        spaltenwert = "nicht erfasst";
                    }
                    spaltenwert += ";";

                    pw.println(spaltenwert);
                }

                if (i == 0) {
                    pw.println("Keine Datensätze verfügbar");
                }

                pw.close();
                ret = true;
            } catch (SQLException e) {
                String error = "\n\t\"Fehler!\n\t" + e.toString();
                System.err.println(error);
            }
        }

        return ret;
    }

    public boolean lagerToCSV(List<>) {
        boolean ret = false;

        if (jdbc != null) {
            ResultSet rs = jdbc.getLagerTabelle();
            File path = new File("Lager.csv");

            ret = createCSV(path, rs);
        }

        return ret;
    }

}
