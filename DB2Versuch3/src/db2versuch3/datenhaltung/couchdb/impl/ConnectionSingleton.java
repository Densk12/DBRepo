/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2versuch3.datenhaltung.couchdb.impl;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

/**
 *
 * @author Dennis Sk
 */
public class ConnectionSingleton {
    private static ConnectionSingleton instance;
    private CouchDbInstance dbInstance;
    
    public static ConnectionSingleton getInstance() throws Exception {
        if (instance == null) {
            instance = new ConnectionSingleton();
        }
        return instance;
    }
    
    private ConnectionSingleton() throws Exception {
        HttpClient httpClient = new StdHttpClient.Builder().url("http://139.6.17.5:5984").build();
        dbInstance = new StdCouchDbInstance(httpClient);
    }
    
    public CouchDbConnector getConnection(String segment) {
        return dbInstance.createConnector(segment, true);
    }
}
