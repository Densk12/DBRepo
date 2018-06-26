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
    public boolean lagerCSVEinlesen();
    public List<Lager> lagerAllesAnzeigen();
    public Lager lagerLesenById(int id);
    public boolean lagerUpdate(Lager lager);
    public boolean lagerDeleteById(int id);
}
