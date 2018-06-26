package db2versuch3.datenhaltung.oracledb.services;

import java.sql.Connection;

/**
 * Schnittstellenklasse IDatabase
 */
public interface IDatabase {
    public abstract Connection getConnection() throws Exception;
}
