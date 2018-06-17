package db2versuch3.datenhaltung.oracledb.impl;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 * Klasse ConnectionSingleton - erstellt eine konsistente Verbindung zur
 * Oracle-DB
 *
 * @version 1.0
 */
public class ConnectionSingleton {

    private static ConnectionSingleton instance;
    private Connection connection;
    
    static ConnectionSingleton getInstance() {
        if(instance == null) {
            instance = new ConnectionSingleton();
        }
        return instance;
    }

    private ConnectionSingleton() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            String error = "\n\tFehler! Der Oracle-Treiber konnte nicht geladen werden!\n\t" + e.toString();
            System.err.println(error);
            System.exit(-1);
        }

        try {
            OracleDataSource ods = new OracleDataSource();
            String url = "jdbc:oracle:thin:dbprak23/db2017@//schelling.nt.fh-koeln.de:1521/xe";
            ods.setURL(url);

            connection = ods.getConnection();
        } catch (SQLException e) {
            String error = "\n\tFehler! Es konnte keine Verbindung zur Datenbank hergestellt werden!\n\t" + e.toString();
            System.err.println(error);
            System.exit(-1);
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
}
