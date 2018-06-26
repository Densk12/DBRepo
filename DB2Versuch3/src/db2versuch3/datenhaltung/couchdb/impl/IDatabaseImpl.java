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
public class IDatabaseImpl {
    public CouchDbConnector getConnection(String segment) throws Exception {
        return ConnectionSingleton.getInstance().getConnection(segment);
    }
}
