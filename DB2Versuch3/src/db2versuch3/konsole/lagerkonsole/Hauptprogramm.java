package db2versuch3.konsole.lagerkonsole;

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

        do {
            System.out.println("\n\tMenue:");
            System.out.println("\n\t  -Lager.csv erzeugen (1)");
            System.out.println("\n\t  -");
            System.out.println("\n\t  -");
            System.out.println("\n\t  -Beenden            (0)");

            int choice = -1;
            do {
                System.out.print("\n\tEingabe: ");

                try {
                    choice = Integer.parseInt(in.readLine());

                } catch (IOException e) {
                    String error = "\n\tFehler! Falsche Eingabe";
                    error += "\n\t" + e.toString();
                    System.err.println(error);
                }
            } while (0 > choice || choice > 1);

            switch (choice) {
                case 1:
                    

                    break;
            }

        } while (choice != 0);

    }

}
