package db2versuch3.datenhaltung.lagerdaten.service;

import db2versuch3.datenhaltung.oracledb.entities.Lager;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Dennis Sk
 */
public interface ILagerSQL {
    public abstract void setConnection(Connection connection);
    public List<Lager> getAlleLager() throws Exception;
}
