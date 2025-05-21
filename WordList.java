package miniproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordList {
    private Random random = new Random();
    public List<String[]> wordLists = new ArrayList<>();

    private String[] wordList1 = {"STOP", "SHOT", "SWAP", "WOMP", "SHOP"};
    private String[] wordList2 = {"AGES", "WOOD", "SPOT", "GETS", "WHEN", 
        "POTS", "FLAT", "DRAG", "WEAK", "HUTS", "EHOS"};
    private String[] wordList3 = {"SHOT", "HURT", "SELL", "GIVE", "SURE",
        "GEAR", "SENT", "FIRE", "GLOW", "WEEK", "ONES", "SICK"};
    private String[] wordList4 = {"SPIES", "JOINS", "TIRES", "TRICK", "TRIED", 
        "SKIES", "TERMS", "THIRD", "FRIES", "PRICE", "TRIES", "TRITE", "TANKS", 
        "THICK", "TRIBE", "TEXAS"};
    private String[] wordList5 = {"TAKES", "KNOWN", "KICKS", "STARK", "BOOTS", "BATON", 
        "CLEAR", "CRIME", "WASTE", "CLOSE", "SWORD", "SLAVE", "FARGO", "MAYBE", "MALES"};
    private String[] wordList6 = {"MULTIPLY","FOLLOWED", "FAREWELL","CONTINUE", "SOUTHERN"};
    private String[] wordList7 = {"SHACKLES", "HAPPENED", "IMPLANTS","SUPPOSED", "REPLACED"};
    private String[] wordList8 = {"MODIFIED","INJECTED","DETECTOR","CREMATED", "DESIGNED"};
    private String[] wordList9 = {"SUFFERED","ASCENDED","PROVIDED","DISPUTES", "EXTENDED", 
        "SOMEWHAT","SATURDAY","DEMANDED", "SAMANTHA", "SUBURBAN"};
    private String[] wordList10 = {"CONFIRM","ROAMING", "FARMING","GAINING", "HEARING", 
        "MANKIND", "MORNING", "LEAVING", "CONSIST","HOUSING", "GETTING","TACTICS", 
        "ENGLISH","PACKING", "SELLING","FENCING"};
    
    public WordList(){ //Constructor
        wordLists.add(wordList1); wordLists.add(wordList2);
        wordLists.add(wordList3); wordLists.add(wordList4);
        wordLists.add(wordList5); wordLists.add(wordList6);
        wordLists.add(wordList7); wordLists.add(wordList8);
        wordLists.add(wordList9); wordLists.add(wordList10);
    }

    public String[] getWordList() {
        return wordLists.get(random.nextInt(wordLists.size()));
    }
}