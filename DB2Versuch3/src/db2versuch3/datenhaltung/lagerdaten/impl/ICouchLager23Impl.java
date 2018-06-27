package db2versuch3.datenhaltung.lagerdaten.impl;

import db2versuch3.datenhaltung.couchdb.entites.Lager;
import db2versuch3.datenhaltung.lagerdaten.service.ICouchLager23;
import java.util.List;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;

/**
 *
 * @author Dennis Sk
 */
public class ICouchLager23Impl implements ICouchLager23 {

    CouchDbConnector couchDbConnector;

    public void setConnection(CouchDbConnector couchDbConnector) throws Exception {
        if (couchDbConnector != null) {

            this.couchDbConnector = couchDbConnector;

        }
    }

    public boolean lagerCSVEinfuegen(List<Lager> lagerListe) {
        boolean ret = false;

        if (couchDbConnector != null && lagerListe != null && lagerListe.size() > 0) {

            for (Lager lager : lagerListe) {

                couchDbConnector.create(lager);

            }

            ret = true;

        }

        return ret;
    }

    public List<Lager> lagerAllesLesen() {
        List<Lager> lagerListe = null;

        if (couchDbConnector != null) {

            ViewQuery vQuery = new ViewQuery().allDocs().includeDocs(true);
            lagerListe = couchDbConnector.queryView(vQuery, Lager.class);

        }

        return lagerListe;
    }

    public Lager lagerLesenById(String id) {
        Lager lager = null;

        if (couchDbConnector != null && id != null) {

            lager = couchDbConnector.get(Lager.class, id);

        }

        return lager;
    }

    public boolean lagerUpdate(Lager lager) {
        boolean ret = false;

        if (couchDbConnector != null && lager != null) {

            couchDbConnector.update(lager);
            ret = true;

        }

        return ret;
    }

    public boolean lagerDeleteById(String id) {
        boolean ret = false;

        if (couchDbConnector != null && id != null) {

            Lager lager = couchDbConnector.get(Lager.class, id);

            if (lager != null) {

                couchDbConnector.delete(id);

            }

        }
        
        return false;
    }
    
}
