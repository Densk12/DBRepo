package db2versuch3.fachlogik.lagersteuerung.impl;

import db2versuch3.fachlogik.lagersteuerung.services.ILagerOracleSteuerung;

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
    }
    
}
