/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2versuch3.datenhaltung.couchdb.services;

import org.ektorp.CouchDbConnector;

/**
 *
 * @author Dennis Sk
 */
public interface IDatabase {
    public CouchDbConnector getConnection(String segment);
}