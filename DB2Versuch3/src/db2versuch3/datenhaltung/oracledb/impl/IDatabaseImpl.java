package db2versuch3.datenhaltung.oracledb.impl;

import db2versuch3.datenhaltung.oracledb.services.IDatabase;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Klasse IDatabaseImpl - Implementiert alle Methoden der Schnittstellenklasse
 * IDatabase. Bietet nach aussen den Zugriff zur Oracle-DB an
 * 
 * @version 1.0
 */
public class IDatabaseImpl implements IDatabase {
    
    /**
     * Methode getConnection - liefert ein konsistentes Medium zur Oracle-DB
     * @return Connection
     */
    @Override
    public Connection getConnection() throws Exception {
        return ConnectionSingleton.getInstance().getConnection();
    }
    
}
