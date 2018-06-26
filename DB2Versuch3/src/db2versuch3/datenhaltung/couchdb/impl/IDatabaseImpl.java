package db2versuch3.datenhaltung.couchdb.impl;

import db2versuch3.datenhaltung.couchdb.services.IDatabase;
import org.ektorp.CouchDbConnector;

/**
 *
 * @author Dennis Sk
 */
public class IDatabaseImpl implements IDatabase {
    @Override
    public CouchDbConnector getConnection(String segment) throws Exception {
        return ConnectionSingleton.getInstance().getConnection(segment);
    }
}
