package db2versuch3.fachlogik.lagersteuerung.services;

import db2versuch3.datenhaltung.couchdb.entites.Lager;
import java.util.List;

/**
 *
 * @author marius
 */
public interface ILagerCouchSteuerung {
    public boolean lagerCSVEinfuegen() throws Exception;
    public List<Lager> lagerAllesAnzeigen() throws Exception;
    public Lager lagerLesenById(String id) throws Exception;
    public boolean lagerUpdate(Lager lager) throws Exception;
    public boolean lagerDeleteById(String id) throws Exception;
}
