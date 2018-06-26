/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public Lager lagerLesenById(int id) throws Exception;
    public boolean lagerUpdate(Lager lager) throws Exception;
    public boolean lagerDeleteById(int id) throws Exception;
}
