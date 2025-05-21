package miniproject;

import java.util.Random;

class Terminal {
    private String[] words;
    private String password;
    private WordList wordList = new WordList();
    private Random random = new Random();

    public Terminal() { //Constructor
        words = wordList.getWordList();
        password = words[random.nextInt(words.length)];
    }

    public String[] getWords() { return words; }    

    public String getPassword() { return password; }

}