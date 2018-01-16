package com.vrymash.db;

import java.sql.Connection;

/**
 * Created by vadym on 12.01.15.
 */
public interface IDBConnector {

    public Connection getConnection() throws Exception ;
    public void closeConnection();
}
