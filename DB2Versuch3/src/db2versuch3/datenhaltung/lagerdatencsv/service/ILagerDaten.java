package db2versuch3.datenhaltung.lagerdatencsv.service;

import java.sql.Connection;

/**
 * Schnittstellenklasse ILagerVerwaltung
 * 
 * @version 1.0
 */
public interface ILagerDaten {
    public abstract void setConnection(Connection connection);
    public abstract void lagertToCSV() throws Exception;
}
