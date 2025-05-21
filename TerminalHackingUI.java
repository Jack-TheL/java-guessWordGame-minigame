package miniproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TerminalHackingUI extends Application {
    private TerminalHackingGame game;
    private TextArea outputArea;
    private TextField inputField;
    private Button submitButton;
    private Label attemptsLabel;
    private VBox leftPane;

    @Override
    public void start(Stage primaryStage) {
        game = new TerminalHackingGame();

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        // สร้างส่วนของชื่อเกมข้างบนสุด
        Label gameTitleLabel = new Label("Terminal Hacking");
        gameTitleLabel.setStyle("-fx-font-size: 28px;");

        root.setTop(gameTitleLabel);
        // สร้างส่วนของฝั่งซ้าย ()
        leftPane = new VBox();
        leftPane.setSpacing(10);
        Label leftPaneLabel = new Label("Select a Word");
        leftPaneLabel.setStyle("-fx-font-size: 18px;");
        leftPane.getChildren().add(leftPaneLabel);
        for(String word : game.getWords()){
            Button wordButton = new Button(word);
            wordButton.setOnAction(event -> inputField.setText(word));
            leftPane.getChildren().add(wordButton);
        }
        root.setLeft(leftPane);
        // สร้างส่วนของฝั่งขวา ()
        VBox rightPane = new VBox();
        rightPane.setSpacing(10);
        Label rightPaneLabel = new Label("Terminal Display");
        rightPaneLabel.setStyle("-fx-font-size: 18px;");
        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(550);
        outputArea.setStyle("-fx-font-size: 14px;");

        rightPane.getChildren().addAll(rightPaneLabel, outputArea);
        root.setRight(rightPane);
        // สร้างส่วนของช่องใส่รหัสและเริ่มเกมใหม่ข้างล่างสุด
        HBox inputBox = new HBox();
        inputBox.setSpacing(10);

        attemptsLabel = new Label(game.getAttemptsLeft() +" Attempt(s) Left");
        attemptsLabel.setStyle("-fx-font-size: 16px;");
        inputField = new TextField();
        inputField.setPromptText("Enter Password");
        inputField.setPrefWidth(150);

        submitButton = new Button("Submit");
        submitButton.setOnAction(event -> submitGuess());

        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction(event -> startNewGame());

        inputBox.getChildren().addAll(attemptsLabel ,inputField, submitButton, newGameButton);
        root.setBottom(inputBox);
        // แสดงผลของ UI
        Scene scene = new Scene(root, 900, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Terminal Hacking Game");
        primaryStage.show();
        updateUI();
    }
    // เมื่อกดปุ่ม sumbit
    private void submitGuess() {
        String guess = inputField.getText();
        outputArea.appendText(guess + "\n");
        if (!guess.isEmpty()) {
            if (game.guessPassword(guess)) {
                outputArea.appendText(">Access Granted!\n");
                outputArea.appendText("------------------------------------------\n");
                outputArea.appendText("Welcome to Terminal\n");
                outputArea.appendText("Last Login: Wed Oct 11 22:01:19 on ttyS0\n\n");
                outputArea.appendText("root@ubuntu:~$ _\n\n");
                outputArea.appendText("--- Terminal has been Hacked, Game Over ---");
                gameOver();
            } else {
                outputArea.appendText(">Access Denied!\n");
                attemptsLabel.setText(game.getAttemptsLeft()+" Attempt(s) Left");
                if (game.isGameOver()) {
                    outputArea.appendText("------------------------------------------\n\n");
                    outputArea.appendText("Terminal Locked, ");
                    outputArea.appendText("Please Contact an Administrator\n\n");
                    outputArea.appendText("--- Terminal has been Permanently Locked, Game Over ---\n");
                    outputArea.appendText("> The Correct Password was " + game.getPassword());
                    gameOver();
                    return;
                }
                outputArea.appendText(">Number of Correct Characters in Correct Position: ");
                outputArea.appendText(countCorrectCharactersAndPosition(guess) + "/" +
                    game.getPassword().length()+ "\n");
                outputArea.appendText(">Enter Another Password: ");
                inputField.clear();
            }
        }
    }
    //เมื่อกดปุ่ม New Game
    private void startNewGame() {
        game = new TerminalHackingGame();
        attemptsLabel.setText(game.getAttemptsLeft()+" Attempt(s) Left");
        leftPane.getChildren().clear();
        for(String word : game.getWords()){
            Button wordButton = new Button(word);
            wordButton.setOnAction(event -> inputField.setText(word));
            leftPane.getChildren().add(wordButton);
        }
        updateUI();
    }
    //
    private void gameOver() { submitButton.setDisable(true); }
    //
    private void updateUI() {
        inputField.clear();
        outputArea.clear();
        outputArea.appendText("--- ENTER PASSWORD NOW ---\n");
        outputArea.appendText(">Enter Password: ");
        inputField.setEditable(false);
        submitButton.setDisable(false);
    }
    //นับจำนวนตัวอักษรที่ใส่ถูกและอยู่ถูกตำแหน่ง
    private int countCorrectCharactersAndPosition(String guess) {
        int count = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == game.getPassword().charAt(i)) {
                count++;
            }
        }
        return count;
    }

    // Main Program Begin here!!
    public static void main(String[] args) { launch(args); }
}