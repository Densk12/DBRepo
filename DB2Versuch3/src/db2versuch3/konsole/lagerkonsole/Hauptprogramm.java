package db2versuch3.konsole.lagerkonsole;

import db2versuch3.datenhaltung.couchdb.entites.Lager;
import db2versuch3.fachlogik.lagersteuerung.impl.ILagerCouchSteuerungImpl;
import db2versuch3.fachlogik.lagersteuerung.impl.ILagerOracleSteuerungImpl;
import db2versuch3.fachlogik.lagersteuerung.services.ILagerCouchSteuerung;
import db2versuch3.fachlogik.lagersteuerung.services.ILagerOracleSteuerung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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
            System.out.println("1\tLager.csv erzeugen");
            System.out.println("2\tDatensätze aus Lager.csv in CouchDB-Segment einfügen");
            System.out.println("3\tDaten aus CouchDB-Segment lesen");
            System.out.println("4\tDatensatz anhand einer ID aus CouchDB lesen");
            System.out.println("5\tDatensatz ändern");
            System.out.println("6\tDatensatz anhand einer ID aus CouchDB löschen");
            System.out.println("q\tBeenden");
            
            ILagerCouchSteuerung steu;
            try {
                steu = new ILagerCouchSteuerungImpl();
            }
            catch(Exception e) {
                System.err.println(e.getMessage());
                return;
            }

            String input;
            do {
                System.out.print("\n\tEingabe: ");
                try {
                    input = in.readLine();
                    if(input.equals("q"))
                        choice = 7;
                    else {
                        try {
                            choice = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
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
                
            } while (choice > 7 || choice < 1);

            switch (choice) {
                case 1: // Daten aus Oracle holen und in eine CSV-Datei schreiben
                    ILagerOracleSteuerung lagerSteu = new ILagerOracleSteuerungImpl();
                    try {
                        lagerSteu.lagerCSVErstellen();
                    } catch (Exception e) {
                        String error = "\n\tFehler! Es konnte keine Lager.csv Datei";
                        error += "erstellt werden\n\t" + e.toString();
                        System.err.println(error);
                    }
                    break;
                case 2: // CSV-Daten in CouchDB schreiben
                    try {
                        if(steu.lagerCSVEinfuegen())
                            System.out.print("OK");
                        else
                            System.out.print("Fehler");
                    }
                    catch(Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3: // Alle Datensätze aus CouchDB anzeigen
                    try {
                        showAlles(steu.lagerAllesAnzeigen());
                    }
                    catch(Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4: // Lager-Datensatz anhand einer ID anzeigen
                    System.out.print("Bitte Lager-ID eingeben: ");
                    choice = getIdInput();
                    try {
                        Lager lager = steu.lagerLesenById(choice);
                        System.out.print("Lagernumme: \t" + lager.getLnr());
                        System.out.print("Lagerort: \t" + lager.getLort());
                        System.out.print("Postleitzahl: \t" + lager.getLplz());
                        System.out.print("Artikelanzahl: \t" + lager.getAnzart());
                    }
                    catch(Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5: // Lager-Datensatz bearbeiten
                    System.out.print("Bitte Lager-ID eingeben: ");
                    choice = getIdInput();
                    wechselLagerDaten(new Lager());
                    break;
                case 6: // Lager-Datensatz löschen
                    System.out.print("Bitte Lager-ID eingeben: ");
                    choice = getIdInput();
                    try {
                        if(steu.lagerDeleteById(choice))
                            System.out.print("Datensatz wurde entfernt");
                        else
                            System.out.print("Fehler");
                    }
                    catch(Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 7: // Programm verlassen
                    System.out.println("\nAuf Wiedersehen!");
                    break;
            }

        } while (choice != 7);

    }

    private static int getIdInput() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(in.readLine());
        }
        catch (NumberFormatException | IOException e) {
            String error = "\n\tFehler! Falsche Eingabe";
            error += "\n\t" + e.toString();
            System.err.println(error);
            return -1;
        }
    }
    
    private static Lager wechselLagerDaten(Lager lager) {
        if( lager == null)
            return null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Bitte geben Sie eine neue Lager ID ein " +
                "oder drücken die Enter-Taste wenn sie diese nicht " + 
                "ändern möchten (bisherige wert: " + lager.getId() + "): ");
        try {
            String input = in.readLine();
            if(input.length() > 0) {
                try {
                    int num = Integer.parseInt(input);
                    lager.setLnr(num);
                }
                catch (NumberFormatException e) {
                    
                }
            }
        } catch (IOException e) {
            
        }
        
        System.out.print("Bitte geben Sie einen neuen Lagerstandort ein " +
                "oder drücken die Enter-Taste wenn sie es nicht " + 
                "ändern möchten (bisherige wert: " + lager.getLort() + "): ");
        try {
            String input = in.readLine();
            if(input.length() > 0) {
                lager.setLort(input);
            }
        }
        catch(IOException e) {
            
        }
        
        System.out.print("Bitte geben Sie eine neue Postleitzahl ein " +
                "oder drücken die Enter-Taste wenn sie diese nicht " + 
                "ändern möchten (bisherige wert: " + lager.getLplz() + "): ");
        try {
            String input = in.readLine();
            if(input.length() > 0) {
                lager.setLplz(input);
            }
        }
        catch(IOException e) {
            
        }
        
        System.out.print("Bitte geben Sie die neue Artikelanzahl ein " +
                "oder drücken die Enter-Taste wenn sie diese nicht " + 
                "ändern möchten (bisherige wert: " + lager.getAnzart() + "): ");
        try {
            String input = in.readLine();
            if(input.length() > 0) {
                 try {
                    int num = Integer.parseInt(input);
                    lager.setAnzart(num);
                }
                catch (NumberFormatException e) {
                    
                }
            }
        }
        catch(IOException e) {
            
        }
        
        return lager;
    }
    
    private static void showAlles(List<Lager> liste) {
        System.out.println("lnr\tlort\tlplz\tanzart");
        for(Lager lager : liste) {
            System.out.println(lager.getLnr() + "\t" + lager.getLort() + "\t" +
                    lager.getLplz()+ "\t" + lager.getAnzart());
        }
    }
}
