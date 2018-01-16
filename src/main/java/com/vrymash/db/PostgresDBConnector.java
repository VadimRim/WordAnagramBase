package com.vrymash.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by vadym on 12.01.15.
 */
public class PostgresDBConnector implements IDBConnector {

    public final String DRIVER_NAME = "org.postgresql.Driver";

    private String url;
    private String user;
    private String password;
    private Connection conn = null;

    public PostgresDBConnector(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws Exception{
        Class.forName(DRIVER_NAME);
        Properties props = new Properties();
        props.setProperty("user",this.user);
        props.setProperty("password",this.password);
        this.conn = DriverManager.getConnection(url, props);
        return conn;
    }

    public void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
