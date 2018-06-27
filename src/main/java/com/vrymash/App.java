package com.vrymash;

import com.vrymash.db.IDBConnector;
import com.vrymash.db.PostgresDBConnector;
import com.vrymash.service.SingleWordService;
import com.vrymash.word.Word;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        /*Word word = new Word("Hello");
        System.out.println(word.getErrorMessage());
        System.out.println(word.toString());*/

        IDBConnector dbConnectro = new PostgresDBConnector("jdbc:postgresql://localhost/wordanagram","postgres","root");
        try{
            /*Connection conn = dbConnectro.getConnection();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM proof_words");
            while(rs.next()){
                String word = rs.getString("word");
                System.out.println(word);
            }*/

            SingleWordService sws = new SingleWordService();
            //sws.putWord("congratulation");
            System.out.print(sws.getWordByText("congratulation"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
