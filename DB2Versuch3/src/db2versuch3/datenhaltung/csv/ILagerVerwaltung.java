package db2versuch3.datenhaltung.csv;

import db2versuch3.datenhaltung.oracledb.entities.Lager;
import java.util.List;

/**
 * Schnittstellenklasse ILagerVerwaltung
 * 
 * @version 1.0
 */
public interface ILagerVerwaltung {
    public abstract boolean lagertToCSV(List<Lager> lagerListe);
}
