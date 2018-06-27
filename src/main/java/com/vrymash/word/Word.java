package com.vrymash.word;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by vrymash on 08.01.2015.
 */
public abstract class Word {

    private Integer blockA = 1000000000; // [0..8]
    private Integer blockB = 1000000000; // [9..17]
    private Integer blockC = 1000000000; // [18..26]
    private Integer blockD = 1000000000; // [27..35]

    private Integer checkSumA;
    private Integer checkSumB;
    private Integer checkSumC;
    private Integer checkSumD;

    private String word;
    private Locale locale; // to what language a Word belong
    private Integer errorState = 0;
    private String errorMessage = "";

    protected Map<Character, Integer> charToPositionMap = new HashMap();

    /**
     * Class contains four blocks nine digits per each to describe count of letters in a word.
     * If letter uses in the word, proper digit reflect this.
     *
     * If some input information provided for class is wrong it should be checked by errorState
     * and errorMessage.
     *
     * @param blockA
     * @param blockB
     * @param blockC
     * @param blockD
     * @param locale - specifies language for given word.
     */
    public Word(Integer blockA, Integer blockB, Integer blockC, Integer blockD, Locale locale){
        this.blockA = blockA;
        this.blockB = blockB;
        this.blockC = blockC;
        this.blockD = blockD;

        try {
            calculateCheckSums();
        } catch (Exception e){
            errorState = 1;
            errorMessage = e.getMessage();
        }

        this.locale = locale;
    }

    /**
     * Class contains four blocks nine digits per each to describe count of letters in a word.
     * If letter uses in the word, proper digit reflect this.
     *
     * If some input information provided for class is wrong it should be checked by errorState
     * and errorMessage.
     *
     * @param word - given word which is represented by class. Should be defined and non-empty.
     *
     * @param locale - specifies language for given word.
     */
    public Word(String word, Locale locale)
    {
        this.word = word;
        try {
            calculateBlocks();
            calculateCheckSums();
        } catch (Exception e){
            errorState = 1;
            errorMessage = e.getMessage();
        }

        this.locale = locale;
    }

    @Override
    public String toString(){
        return "word ["+word+
                "] blockA=["+getBlockA()+", "+getCheckSumA()+
                "] blockB=["+getBlockB()+", "+getCheckSumB()+
                "] blockC=["+getBlockC()+", "+getCheckSumC()+
                "] blockD=["+getBlockD()+", "+getCheckSumD()+
                "]";
    }

    /**
     * Method returns error state.
     *
     * @return - not 0 if something wrong happen.
     */
    public Integer getErrorState(){
        return errorState;
    }

    /**
     * Method returns error message if something happen. In the same time errorState should be not 0.
     *
     * @return - message which describe cause of error.
     */
    public String getErrorMessage(){
        return errorMessage;
    }

    public Integer getBlockA(){
        return blockA;
    }

    public Integer getBlockB(){
        return blockB;
    }

    public Integer getBlockC(){
        return blockC;
    }

    public Integer getBlockD(){
        return blockD;
    }

    public Integer getCheckSumA(){
        return checkSumA;
    }

    public Integer getCheckSumB(){
        return checkSumB;
    }

    public Integer getCheckSumC(){
        return checkSumC;
    }

    public Integer getCheckSumD(){
        return checkSumD;
    }

    public String getWord() {return this.word;}

    // ****************************************************
    //         private methods
    //*****************************************************

    private void calculateBlocks() throws Exception{
        if(word == null || word.length() == 0) throw new Exception("Word should not be empty or undefined.");

        populateCharToPositionMap();

        int wordLength = word.length();
        word = word.toLowerCase();
        for (int i = 0; i < wordLength; i++) {
            char letter = word.charAt(i);
            Integer position = charToPositionMap.get(letter);
            if(position >= 0 && position <9 ){
                blockA = updateBlock(blockA, position % 9);
            } else if(position >= 9 && position <18 ){
                blockB = updateBlock(blockB, position % 9);
            } else if(position >= 18 && position <27 ){
                blockC = updateBlock(blockC, position % 9);
            } else if(position >= 27 && position <36 ){
                blockD = updateBlock(blockD, position % 9);
            }
        }
    }

    private Integer updateBlock(Integer block, Integer blockPosition){
        Integer shift = 0;
        switch(blockPosition){
            case 0: shift = 100000000;break;
            case 1: shift = 10000000;break;
            case 2: shift = 1000000;break;
            case 3: shift = 100000;break;
            case 4: shift = 10000;break;
            case 5: shift = 1000;break;
            case 6: shift = 100;break;
            case 7: shift = 10;break;
            case 8: shift = 1;break;
        }
        return block += shift;
    }

    /**
     * Calculate CheckSums for all blocks.
     *
     * @throws Exception - in case of invalid data. Status could be verified via ErrorState.
     */
    private void calculateCheckSums() throws Exception{
        this.checkSumA = calculateCheckSum(blockA);
        this.checkSumB = calculateCheckSum(blockB);
        this.checkSumC = calculateCheckSum(blockC);
        this.checkSumD = calculateCheckSum(blockD);
    }

    /**
     * Method calculates digits in a block which is follow next rule:
     * starts with 1 (this is significant number) and nine digits afterwards.
     * Is uses for calculation of check sum for the given block.
     *
     * @param block - starts with 1 and nine digits afterward. Max value
     *              is 1999999999, minimum is 1000000000.
     * @return - sum of digits in a block without significant number (e.g. for
     *          1001020030 result is 6.
     * @throws Exception - if block does not start with 1 and contains less
     *          than nine digits afterward.
     */
    private Integer calculateCheckSum(Integer block) throws  Exception {
        if(block < 1000000000) throw new Exception("Block ["+block+"] should start with 1 and nine digits afterward.");

        Integer result = 0;
        Integer currentNumber = block;

        do{
            result += currentNumber % 10;
            currentNumber /= 10;
        }
        while(currentNumber > 0);

        result = result - 1; // minus significant digit (always 1!!)
        return result;
    }

    /**
     * Implementation MUST be specified after inheritance according to specified language.
     *
     * This Map includes correlation between a Letter in lowercase and Number which will be saved into DB,
     * e.g. for en_UK such a correlation for 'g' is following:
     *      'g' -> 6 (key='g', value=6)
     */
    protected abstract void populateCharToPositionMap();

}