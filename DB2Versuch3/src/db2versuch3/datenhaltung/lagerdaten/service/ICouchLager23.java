/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2versuch3.datenhaltung.lagerdaten.service;

import db2versuch3.datenhaltung.couchdb.entites.Lager;
import java.util.List;
import org.ektorp.CouchDbConnector;

/**
 *
 * @author Dennis Sk
 */
public interface ICouchLager23 {
    public void setConnection(CouchDbConnector couchDbConnector) throws Exception;
    public boolean lagerCSVEinfuegen(List<Lager> lagerListe);
    public List<Lager> lagerAllesLesen();
    public Lager lagerLesenById(int id);
    public boolean lagerUpdate(Lager lager);
    public boolean lagerDeleteById(int id);
}
