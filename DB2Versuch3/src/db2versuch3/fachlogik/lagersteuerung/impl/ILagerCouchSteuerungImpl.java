package db2versuch3.fachlogik.lagersteuerung.impl;

import db2versuch3.datenhaltung.lagerdaten.impl.ICouchLager23Impl;
import db2versuch3.datenhaltung.lagerdaten.impl.ILagerCSVImpl;
import db2versuch3.datenhaltung.lagerdaten.service.ICouchLager23;
import db2versuch3.datenhaltung.lagerdaten.service.ILagerCSV;
import db2versuch3.fachlogik.lagersteuerung.services.ILagerCouchSteuerung;
import java.util.LinkedList;
import java.util.List;
import org.ektorp.CouchDbConnector;

/**
 *
 * @author marius
 */
public class ILagerCouchSteuerungImpl implements ILagerCouchSteuerung {

    private CouchDbConnector db;

    public ILagerCouchSteuerungImpl() throws Exception {
        db2versuch3.datenhaltung.couchdb.services.IDatabase data
                = new db2versuch3.datenhaltung.couchdb.impl.IDatabaseImpl();

        db = data.getConnection("Lager23");
    }

    @Override
    public boolean lagerCSVEinfuegen() throws Exception {
        boolean ret = false;

        if (db != null) {

            ILagerCSV iLagerCsv = new ILagerCSVImpl();
            iLagerCsv.setFilename("Lager.csv");

            List<db2versuch3.datenhaltung.oracledb.entities.Lager> lagerListOracle = iLagerCsv.CSVToLager();

            List<db2versuch3.datenhaltung.couchdb.entites.Lager> lagerListCouch
                    = new LinkedList<db2versuch3.datenhaltung.couchdb.entites.Lager>();

            for (db2versuch3.datenhaltung.oracledb.entities.Lager lagerOracle : lagerListOracle) {

                db2versuch3.datenhaltung.couchdb.entites.Lager lagerCouch
                        = new db2versuch3.datenhaltung.couchdb.entites.Lager();

                lagerCouch.setLnr(lagerOracle.getLnr());
                lagerCouch.setLort(new String(lagerOracle.getLort()));
                lagerCouch.setLplz(new String(lagerOracle.getLplz()));
                lagerCouch.setAnzart(lagerOracle.getAnzart());

                lagerListCouch.add(lagerCouch);

            }

            if (lagerListCouch.size() > 0) {

                ICouchLager23 couch = new ICouchLager23Impl();
                couch.setConnection(db);

                ret = couch.lagerCSVEinfuegen(lagerListCouch);

            }

        }

        return ret;
    }

    @Override
    public List<db2versuch3.datenhaltung.couchdb.entites.Lager> lagerAllesAnzeigen() throws Exception {
        List<db2versuch3.datenhaltung.couchdb.entites.Lager> lagerListe = null;

        if (db != null) {

            ICouchLager23 iCouch = new ICouchLager23Impl();
            iCouch.setConnection(db);

            lagerListe = iCouch.lagerAllesLesen();

        }

        return lagerListe;
    }

    @Override
    public db2versuch3.datenhaltung.couchdb.entites.Lager lagerLesenById(String id) throws Exception {
        db2versuch3.datenhaltung.couchdb.entites.Lager lager = null;

        if (db != null) {

            ICouchLager23 iCouch = new ICouchLager23Impl();
            iCouch.setConnection(db);

            lager = iCouch.lagerLesenById(id);

        }

        return lager;
    }

    @Override
    public boolean lagerUpdate(db2versuch3.datenhaltung.couchdb.entites.Lager lager) throws Exception {
        boolean ret = false;

        if (db != null) {

            ICouchLager23 iCouch = new ICouchLager23Impl();
            iCouch.setConnection(db);

            ret = iCouch.lagerUpdate(lager);

        }

        return ret;
    }

    @Override
    public boolean lagerDeleteById(String id) throws Exception {
        boolean ret = false;

        if (db != null) {

            ICouchLager23 iCouch = new ICouchLager23Impl();
            iCouch.setConnection(db);

            ret = iCouch.lagerDeleteById(id);

        }

        return ret;
    }

}
