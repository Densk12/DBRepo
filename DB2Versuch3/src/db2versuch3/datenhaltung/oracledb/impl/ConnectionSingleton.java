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

    static ConnectionSingleton getInstance() throws Exception {
        if (instance == null) {
            instance = new ConnectionSingleton();
        }
        return instance;
    }

    private ConnectionSingleton() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        OracleDataSource ods = new OracleDataSource();
        String url = "jdbc:oracle:thin:dbprak23/db2017@//schelling.nt.fh-koeln.de:1521/xe";
        ods.setURL(url);

        connection = ods.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }
}
