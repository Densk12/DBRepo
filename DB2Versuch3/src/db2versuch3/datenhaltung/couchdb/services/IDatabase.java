package db2versuch3.datenhaltung.couchdb.services;

import org.ektorp.CouchDbConnector;

/**
 *
 * @author Dennis Sk
 */
public interface IDatabase {
    public CouchDbConnector getConnection(String segment) throws Exception;
}
