package db2versuch3.datenhaltung.couchdb.impl;

import db2versuch3.datenhaltung.couchdb.entites.Lager;
import db2versuch3.datenhaltung.couchdb.services.CouchLager23;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

/**
 * CouchLager23Impl - Implementiert die Schnittstellenklasse CouchLager23.
 * Bietet CRUD-Operationen auf die CouchDB bzw. dem Segment Lager23 an
 *
 * @author Dennis Sk
 */
public class CouchLager23Impl implements CouchLager23 {

    private static CouchLager23Impl instance;
    private CouchDbConnector db;

    public static CouchLager23Impl getInstance() throws MalformedURLException {
        if (instance == null) {
            instance = new CouchLager23Impl();
        }
        return instance;
    }

    private CouchLager23Impl() throws MalformedURLException {
        HttpClient http = (HttpClient) new StdHttpClient.Builder().url("http://feuerbach.nt.fh-koeln.de:5984/_utils/");
        CouchDbInstance couchDbInstance = new StdCouchDbInstance(http);

        db = couchDbInstance.createConnector("Lager23", true);
    }

    @Override
    public boolean lagerCSVEinfuegen() throws FileNotFoundException {
        boolean ret = false;

        FileReader fr = new FileReader(new File("Lager.csv"));
        BufferedReader in = new BufferedReader(fr);
        
        in.readLine();
        
        String datensatz = null;
        
        while() {
            
        }
       
        
        return ret;
    }

    @Override
    public List<Lager> lagerAllesLesen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lager lagerLesenById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean lagerUpdate(Lager lager) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean lagerDeleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
