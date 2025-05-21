package miniproject;

public class TerminalHackingGame {
    private Terminal terminal;
    private int attemptsLeft;
    private static final int MAX_ATTEMPTS = 4;

    public TerminalHackingGame() { //Constructor
        terminal = new Terminal();
        attemptsLeft = MAX_ATTEMPTS;
    }

    public boolean guessPassword(String guess) {
        attemptsLeft--;
        return guess.equals(getPassword());
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getPassword() {
        return terminal.getPassword();
    }

    public String[] getWords() {
        return terminal.getWords();
    }
}