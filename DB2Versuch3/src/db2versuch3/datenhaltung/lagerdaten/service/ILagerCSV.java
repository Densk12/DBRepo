package db2versuch3.datenhaltung.lagerdaten.service;


import db2versuch3.datenhaltung.oracledb.entities.Lager;
import java.util.List;

/**
 * Schnittstellenklasse ILagerVerwaltung
 * 
 * @version 1.0
 */
public interface ILagerCSV {
    public void setFilename(String filename);
    public abstract boolean lagerToCSV(String[] spalten, List<Lager> lagerListe) throws Exception;
    public abstract List<Lager> CSVToLager() throws Exception;
}
