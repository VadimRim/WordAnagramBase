package com.vrymash.dao;

import com.vrymash.word.Word;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vrymash on 6/25/2018.
 */
public interface IWordDAO {

    public Boolean insertWord(Word aWord) throws SQLException;
    public Word selectWordByText(String text) throws SQLException;

}
