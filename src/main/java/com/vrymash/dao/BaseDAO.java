package com.vrymash.dao;

import com.vrymash.db.IDBConnector;

import java.sql.Connection;

/**
 * Created by vrymash on 6/25/2018.
 */
public class BaseDAO {

    protected Connection conn = null;

    public BaseDAO(IDBConnector dbConnector){
        try{
            conn = dbConnector.getConnection();
        } catch( Exception e){
            e.printStackTrace();
        }

    }
}
