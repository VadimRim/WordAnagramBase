package com.vrymash.db;

import java.sql.Connection;

/**
 * Created by vadym on 12.01.15.
 *
 * Interface to provide a Connection to DB.
 * Could be several implementations to support different databases.
 */
public interface IDBConnector {

    public Connection getConnection() throws Exception ;
    public void closeConnection();
}
