package com.vrymash.dao;

import com.vrymash.db.IDBConnector;
import com.vrymash.db.PostgresDBConnector;
import com.vrymash.word.Word;
import com.vrymash.word.WordFactory;
import com.vrymash.word.WordUK;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vrymash on 6/25/2018.
 */
public class WordPostgresqlDAO extends BaseDAO implements IWordDAO{

    public WordPostgresqlDAO(){
        //TODO: remove hardcode
        super(new PostgresDBConnector("jdbc:postgresql://localhost/wordanagram","postgres","root"));
    }

    public Boolean insertWord(Word aWord) throws SQLException {
        if(conn == null) throw new SQLException("Connection is not established");

        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery("INSERT INTO proof_words (" +
                "block_a, " +
                "block_b, " +
                "block_c, " +
                "block_d," +
                "check_sum_a," +
                "check_sum_b," +
                "check_sum_c," +
                "check_sum_d," +
                "word, " +
                "language_id" +
                ") VALUES (" +
                aWord.getBlockA() + ", " +
                aWord.getBlockB() + ", " +
                aWord.getBlockC() + ", " +
                aWord.getBlockD() + ", " +
                aWord.getCheckSumA() + ", " +
                aWord.getCheckSumB() + ", " +
                aWord.getCheckSumC() + ", " +
                aWord.getCheckSumD() + ", " +
                "\'" + aWord.getWord() + "\', " +
                "1" + //TODO: remove hardcode
                ")");
        //TODO: check rs response?
        return Boolean.TRUE;
    }

    public Word selectWordByText(String text) throws SQLException{
        if(conn == null) throw new SQLException("Connection is not established");

        Word result = null;
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery("SELECT " +
                "word FROM proof_words " +
                " WHERE word = \'" + text + "\'");
        if(rs.next()) {
            String resultWord = rs.getString("word");
            result = WordFactory.create(resultWord);
        }
        return result;
    }
}
