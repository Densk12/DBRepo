package db2versuch3.konsole.lagerkonsole;

import db2versuch3.fachlogik.lagersteuerung.impl.ILagerOracleSteuerungImpl;
import db2versuch3.fachlogik.lagersteuerung.services.ILagerOracleSteuerung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Klasse Hauptrogramm - realisiert die Interaktion mit dem Benutzer. Verwendet
 * die in der Fachlogik spezifizierten Steuerungsklassen
 *
 * @version 1.0
 */
public class Hauptprogramm {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        do {
            choice = -1;
            System.out.println("\tMenue:");
            System.out.println("0\tLager.csv erzeugen");
            System.out.println("1\tAnlegen eines CouchDB-Segmentes");
            System.out.println("2\tDatensätze aus Lager.csv in CouchDB-Segment einfügen");
            System.out.println("3\tDaten aus CouchDB-Segment lesen");
            System.out.println("4\tDatensatz anhand einer ID aus CouchDB lesen");
            System.out.println("5\tDatensatz ändern");
            System.out.println("6\tDatensatz anhand einer ID aus CouchDB löschen");
            System.out.println("q\tBeenden");

            String input;
            do {
                System.out.print("\n\tEingabe: ");
                try {
                    input = in.readLine();
                    if(input.equals("q"))
                        choice = 7;
                    else {
                        try {
                            choice = Integer.parseInt(in.readLine());
                        } catch (IOException e) {
                            String error = "\n\tFehler! Falsche Eingabe";
                            error += "\n\t" + e.toString();
                            System.err.println(error);
                            choice = -1;
                        }
                    }
                }
                catch(IOException e) {
                    String error = "\n\tFehler beim esen der Eingabedaten.";
                    error += "\n\t" + e.toString();
                    System.err.println(error);
                    choice = -1;
                }
                
            } while (choice > 7 || choice < 0);

            switch (choice) {
                case 0:
                    ILagerOracleSteuerung lagerSteu = new ILagerOracleSteuerungImpl();
                    try {
                        lagerSteu.lagerCSVErstellen();
                    } catch (Exception e) {
                        String error = "\n\tFehler! Es konnte keine Lager.csv Datei";
                        error += "erstellt werden\n\t" + e.toString();
                        System.err.println(error);
                    }
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.print("Bitte Lager-ID eingeben: ");
                    choice = getIdInput();
                    break;
                case 5:
                    System.out.print("Bitte Lager-ID eingeben: ");
                    choice = getIdInput();
                    break;
                case 6:
                    System.out.print("Bitte Lager-ID eingeben: ");
                    choice = getIdInput();
                    break;
                case 7:
                    System.out.println("\nAuf Wiedersehen!");
                    break;
            }

        } while (choice != 7);

    }

    private static int getIdInput() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(in.readLine());
        } catch (IOException e) {
            String error = "\n\tFehler! Falsche Eingabe";
            error += "\n\t" + e.toString();
            System.err.println(error);
            return -1;
        }
    }
}
