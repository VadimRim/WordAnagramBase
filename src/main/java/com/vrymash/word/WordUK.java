package com.vrymash.word;

import java.util.Locale;

/**
 * Created by vrymash on 6/25/2018.
 */
public class WordUK extends Word{

    public WordUK(Integer blockA, Integer blockB, Integer blockC, Integer blockD){
        super(blockA, blockB, blockC, blockD, Locale.UK);
    }

    public WordUK(String word){
        super(word, Locale.UK);
    }

    protected void populateCharToPositionMap(){
        if(charToPositionMap.size() > 0) return;

        charToPositionMap.put(new Character('a'),0);
        charToPositionMap.put(new Character('b'),1);
        charToPositionMap.put(new Character('c'),2);
        charToPositionMap.put(new Character('d'),3);
        charToPositionMap.put(new Character('e'),4);
        charToPositionMap.put(new Character('f'),5);
        charToPositionMap.put(new Character('g'),6);
        charToPositionMap.put(new Character('h'),7);
        charToPositionMap.put(new Character('i'),8);
        charToPositionMap.put(new Character('j'),9);
        charToPositionMap.put(new Character('k'),10);
        charToPositionMap.put(new Character('l'),11);
        charToPositionMap.put(new Character('m'),12);
        charToPositionMap.put(new Character('n'),13);
        charToPositionMap.put(new Character('o'),14);
        charToPositionMap.put(new Character('p'),15);
        charToPositionMap.put(new Character('q'),16);
        charToPositionMap.put(new Character('r'),17);
        charToPositionMap.put(new Character('s'),18);
        charToPositionMap.put(new Character('t'),19);
        charToPositionMap.put(new Character('u'),20);
        charToPositionMap.put(new Character('v'),21);
        charToPositionMap.put(new Character('w'),22);
        charToPositionMap.put(new Character('x'),23);
        charToPositionMap.put(new Character('y'),24);
        charToPositionMap.put(new Character('z'),25);
    }
}
