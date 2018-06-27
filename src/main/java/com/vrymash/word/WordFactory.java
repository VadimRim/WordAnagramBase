package com.vrymash.word;

import java.util.Locale;

/**
 * Created by vrymash on 6/25/2018.
 */
public class WordFactory {

    public static Word create(String word, Locale locale){
        Word result = null;
        if(Locale.UK.equals(locale)){
            result = new WordUK(word);
        }
        return result;
    }

    public static Word create(String word){
        Word result = null;
        //TODO: detect what language a word belong to
        result = create(word, Locale.UK); //TODO: change this line!!!
        return result;
    }

}
