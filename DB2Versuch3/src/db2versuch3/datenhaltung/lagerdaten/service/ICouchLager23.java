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
    public Lager lagerLesenById(String id);
    public boolean lagerUpdate(Lager lager);
    public boolean lagerDeleteById(String id);
}
