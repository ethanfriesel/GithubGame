package com.example.githubgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameController {
    @FXML
    private Label text;

    @FXML
    private Button myButton;
    @FXML
    private Button buttonA;
    @FXML
    private Button buttonB;
    @FXML
    private Button buttonC;
    @FXML
    private Button buttonD;
    @FXML
    private Button submit;
    private final String SELECTED_COLOR = "-fx-background-color: Orange";

    private GameLogic game;
    private int turn;
    private int correct;
    private boolean selected;
    private VocabTerm term;
    private String[] choices;

    public GameController(){
        turn = 0;
        correct = 0;
        selected = false;
        game = new GameLogic();
        term = game.run(turn);
        text.setText(term.getDefinition());
        choices = term.getWordChoices();

    }

    public void buttonClicked(ActionEvent itemClicked){
        Button buttonClicked = (Button) itemClicked.getSource();
        if (buttonClicked.getText().equals("Submit")) {
            if (selected) {

            }
            submit.setStyle(SELECTED_COLOR);
        }
    }
}