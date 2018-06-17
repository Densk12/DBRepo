package db2versuch3.datenhaltung.oracledb.services;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Schnittstellenklasse IDatabase
 */
public interface IDatabase {
    public abstract Connection getConnection() throws SQLException;
}
