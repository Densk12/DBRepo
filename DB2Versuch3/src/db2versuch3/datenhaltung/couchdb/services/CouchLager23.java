package db2versuch3.datenhaltung.couchdb.services;

import db2versuch3.datenhaltung.couchdb.entites.Lager;
import java.util.List;

/**
 * Schnittstellenklasse CouchLager23
 * 
 * @version 1.0
 */
public interface CouchLager23 {
    public abstract boolean lagerCSVEinfuegen();
    public abstract List<Lager> lagerAllesLesen();
    public abstract Lager lagerLesenById(int id);
    public abstract boolean lagerUpdate(Lager lager);
    public abstract boolean lagerDeleteById(int id);
}
