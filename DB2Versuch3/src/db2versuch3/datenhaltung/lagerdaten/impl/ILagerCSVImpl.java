package db2versuch3.datenhaltung.lagerdaten.impl;

import db2versuch3.datenhaltung.lagerdaten.service.ILagerCSV;
import db2versuch3.datenhaltung.oracledb.entities.Lager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dennis Sk
 */
public class ILagerCSVImpl implements ILagerCSV {

    private String filename;

    public ILagerCSVImpl() {
    }

    @Override
    public void setFilename(String filename) {

        if (filename != null) {

            this.filename = filename;

        }

    }

    @Override
    public boolean lagerToCSV(String[] spalten, List<Lager> lagerListe) throws Exception {

        boolean ret = false;

        if (spalten != null && lagerListe != null) {

            PrintWriter pw = new PrintWriter(new FileWriter(filename), true);

            if (lagerListe.size() > 0 && spalten.length > 0) {

                int i;
                for (i = 0; i < spalten.length - 1; i++) {

                    pw.print("\"" + spalten[i] + "\",");

                }

                pw.println("\"" + spalten[i] + "\"");

                for (Lager lager : lagerListe) {

                    int lnr = lager.getLnr();
                    String lort = lager.getLort();
                    String lplz = lager.getLplz();
                    int anzart = lager.getAnzart();

                    pw.println(lnr + "," + lort + "," + lplz + "," + anzart);

                }

                ret = true;

            } else {

                pw.println("Es sind keine Datensätze verfügbar!");

            }

            pw.close();

        }

        return ret;

    }

    @Override
    public List<Lager> CSVToLager() throws Exception {

        List<Lager> lagerList = null;

        if (filename != null) {

            lagerList = new LinkedList<Lager>();

            BufferedReader in = new BufferedReader(new FileReader(filename));

            in.readLine();

            String datensatz;
            String lnr = new String();
            String lort = new String();
            String lplz = new String();
            String anzart = new String();
            int zaehler = 0;

            while ((datensatz = in.readLine()) != null) {
                
                String[] felder = datensatz.split(",");
                if(felder.length > 0)
                    lnr = felder[0];
                if(felder.length > 1)
                    lort = felder[1];
                if(felder.length > 2)
                    lplz = felder[2];
                if(felder.length > 3)
                    anzart = felder[3];

                Lager lager = new Lager(Integer.parseInt(lnr), lort, lplz, Integer.parseInt(anzart));

                lagerList.add(lager);
            }
        }

        return lagerList;

    }

}
