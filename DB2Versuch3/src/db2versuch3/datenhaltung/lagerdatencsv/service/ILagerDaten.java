package db2versuch3.datenhaltung.lagerdatencsv.service;

import db2versuch3.datenhaltung.oracledb.entities.Lager;
import java.util.List;

/**
 * Schnittstellenklasse ILagerVerwaltung
 * 
 * @version 1.0
 */
public interface ILagerDaten {
    public abstract boolean lagertToCSV(List<Lager> lagerListe);
}
