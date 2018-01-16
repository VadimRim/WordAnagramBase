package com.vrymash.db;

import com.vrymash.word.Word;
import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vadym on 13.01.15.
 */
public class DBConnectorTest extends TestCase {
    private IDBConnector connector;
    private Connection conn;

    public DBConnectorTest(String testName){
        super(testName);
    }

    protected void setUp()throws Exception {
        super.setUp();
        connector = new PostgresDBConnector("jdbc:postgresql://localhost/wordanagram","postgres","root");
        try {
            conn = connector.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void testAdd(){
        System.out.println("1");
        assertNotNull(conn);
    }

    public void testAdd2(){
        Statement ps = null;
        try {
            System.out.println("2");
            ps = conn.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM proof_words");
            assertNotNull(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
