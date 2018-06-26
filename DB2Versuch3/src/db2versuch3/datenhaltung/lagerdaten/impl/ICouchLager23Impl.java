/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2versuch3.datenhaltung.lagerdaten.impl;

import db2versuch3.datenhaltung.couchdb.entites.Lager;
import db2versuch3.datenhaltung.lagerdaten.service.ICouchLager23;
import java.util.LinkedList;
import java.util.List;
import org.ektorp.CouchDbConnector;

/**
 *
 * @author Dennis Sk
 */
public class ICouchLager23Impl implements ICouchLager23 {
    
    CouchDbConnector couchDbConnector;
            
    public void setConnection(CouchDbConnector couchDbConnector) throws Exception {
        if(couchDbConnector != null) {
            this.couchDbConnector = couchDbConnector;
        }
    }
    public boolean lagerCSVEinfuegen(List<Lager> lagerListe) {
        if(lagerListe != null) {
            return false;
        }
        else
            return false;
    }
    public List<Lager> lagerAllesLesen() {
        List<Lager> lager = new LinkedList<>();
        return lager;
    }
    public Lager lagerLesenById(int id) {
        return null;
    }
    public boolean lagerUpdate(Lager lager) {
        return false;
    }
    public boolean lagerDeleteById(int id) {
        return false;
    }
}
