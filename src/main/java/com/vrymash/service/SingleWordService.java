package com.vrymash.service;

import com.vrymash.dao.IWordDAO;
import com.vrymash.dao.WordPostgresqlDAO;
import com.vrymash.word.Word;
import com.vrymash.word.WordFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by vrymash on 6/25/2018.
 *
 * Service for manipulations with a Single Word.
 *
 * WARNING: it is not effective for processing bunch of Words!
 */
public class SingleWordService {

    public void SingleWordService(){

    }

    public void putWord(String aWord){
        Word word = WordFactory.create(aWord);
        IWordDAO wordDAO = new WordPostgresqlDAO();
        try{
            wordDAO.insertWord(word);
        } catch(SQLException se){
            se.printStackTrace();
        }
    }

    public Word getWordByText(String text){
        Word resultWord = null;
        IWordDAO wordDAO = new WordPostgresqlDAO();
        try{
            resultWord = wordDAO.selectWordByText(text);
        } catch(SQLException se){
            se.printStackTrace();
        }
        return resultWord;
    }

    // TODO: following method for MultipleWordService
    //public List<Word> getWordsByBlocks(Integer blockA, Integer blockB, Integer blockC, Integer blockD){
    //}
}
