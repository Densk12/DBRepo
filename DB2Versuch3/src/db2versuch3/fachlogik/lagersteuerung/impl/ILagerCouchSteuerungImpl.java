/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2versuch3.fachlogik.lagersteuerung.impl;

import db2versuch3.datenhaltung.couchdb.entites.Lager;
import db2versuch3.fachlogik.lagersteuerung.services.ILagerCouchSteuerung;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marius
 */
public class ILagerCouchSteuerungImpl implements ILagerCouchSteuerung {
    @Override
    public boolean lagerCSVEinlesen() {
        return false;
    }
    @Override
    public List<Lager> lagerAllesAnzeigen() {
        List<Lager> lager = new LinkedList<>();
        return lager;
    }
    @Override
    public Lager lagerLesenById(int id) {
        return null;
    }
    @Override
    public boolean lagerUpdate(Lager lager) {
        return false;
    }
    @Override
    public boolean lagerDeleteById(int id) {
        return false;
    }
}
