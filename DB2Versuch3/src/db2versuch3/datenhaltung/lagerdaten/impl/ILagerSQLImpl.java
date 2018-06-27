package db2versuch3.datenhaltung.lagerdaten.impl;


import db2versuch3.datenhaltung.lagerdaten.service.ILagerSQL;
import db2versuch3.datenhaltung.oracledb.entities.Lager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dennis Sk
 */
public class ILagerSQLImpl implements ILagerSQL {
    
    private Connection connection;
    
    public ILagerSQLImpl() {
    }
    
    @Override
    public void setConnection(Connection connection) {
        if(connection != null) {
            this.connection = connection;
        }
    }

    @Override
    public List<Lager> getAlleLager() throws Exception {
        List<Lager> lagerListe = null;
        
        if(connection != null) {
            lagerListe = new LinkedList<Lager>();
            
            String sql = "SELECT LA.LNR, LA.LORT, LA.LPLZ FROM LAGERAT LA";
            
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                int anzart = 0;
                int lnr = rs.getInt("LNR");
                String lort = rs.getString("LORT");
                String lplz = rs.getString("LPLZ");
                
                sql = "SELECT COUNT(*) ANZART FROM TABLE(SELECT ARTIKELLISTE FROM "
                        + " LAGERAT WHERE LNR = " + lnr + ")";
                Statement stm2 = connection.createStatement();
                ResultSet rs2 = stm2.executeQuery(sql);
                while(rs2.next()) {
                    anzart = rs2.getInt("ANZART");
                }
                stm2.close();
                rs2.close();
                
                Lager lager = new Lager(lnr, lort, lplz, anzart);
                
                lagerListe.add(lager);
            }
            stm.close();
            rs.close();
        }
        
        return lagerListe;
    }
    
}
