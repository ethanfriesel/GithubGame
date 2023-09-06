package com.example.githubgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;

public class GameController {
    @FXML
    private Label text;
    @FXML
    private Label score;
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
    private final String UNSELECTED_COLOR = "-fx-background-color: White";
    private final String SELECTED_COLOR = "-fx-background-color: Orange";
    private final String LOW_COLOR = "-fx-background-color: Red";
    private final String MED_LOW_COLOR = "-fx-background-color: Orange";
    private final String MED_HIGH_COLOR = "-fx-background-color: Blue";
    private final String HIGH_COLOR = "-fx-background-color: Green";
    private final int LOW_SCORE = 70;
    private final int MED_LOW_SCORE = 80;
    private final int MED_HIGH_SCORE = 90;
    private Button[] buttons;

    private GameLogic game;
    private int turn;
    private int correct;
    private int selected;
    private VocabTerm term;
    private ArrayList<String> choices;

    public void initialize() {
        turn = 0;
        correct = 0;
        selected = -1;
        game = new GameLogic();
        term = game.run(turn);
        text.setText(term.getDefinition());
        choices = new ArrayList<String>(Arrays.asList(term.getWordChoices()));
        System.out.println(choices);
        score.setText("Score: 0/0   0%");

        buttonA.setText(choices.get(0));
        buttonA.setStyle(UNSELECTED_COLOR);
        buttonB.setText(choices.get(1));
        buttonB.setStyle(UNSELECTED_COLOR);
        buttonC.setText(choices.get(2));
        buttonC.setStyle(UNSELECTED_COLOR);
        buttonD.setText(choices.get(3));
        buttonD.setStyle(UNSELECTED_COLOR);
        buttons = new Button[] {buttonA, buttonB, buttonC, buttonD};
    }

    public void buttonClicked(ActionEvent itemClicked){
        Button buttonClicked = (Button) itemClicked.getSource();
        if (buttonClicked.getText().equals("Submit")) {
            if (selected != -1) {
                clearButtons();
                if (buttons[selected].getText().equals(term.getWord())){
                    correct++;
                }
                selected = -1;
                turn++;
                updateScore();
                if (turn > game.vocabLength()){
                    text.setText("Your final score was " + correct + "/" + game.vocabLength());
                    System.exit(0);
                }
                term = game.run(turn);
                text.setText(term.getDefinition());
                choices = new ArrayList<String>(Arrays.asList(term.getWordChoices()));
                buttonA.setText(choices.get(0));
                buttonB.setText(choices.get(1));
                buttonC.setText(choices.get(2));
                buttonD.setText(choices.get(3));
            }
        }
        else {
            int current = choices.indexOf(buttonClicked.getText());
            if (selected == current) {
                clearButtons();
                selected = -1;
            }
            else {
                clearButtons();
                selected = current;
                buttons[selected].setStyle(SELECTED_COLOR);
            }
        }
    }

    public void clearButtons(){
        for (Button b : buttons){
            b.setStyle(UNSELECTED_COLOR);
        }
    }

    public void updateScore(){
        float percent = (float) correct / turn * 100;
        score.setText("Score: " + correct + "/" + turn + "   "  + percent + "%");
        if (percent < LOW_SCORE)
            score.setStyle(LOW_COLOR);
        else if(percent < MED_LOW_SCORE)
            score.setStyle(MED_LOW_COLOR);
        else if (percent < MED_HIGH_SCORE)
            score.setStyle(MED_HIGH_COLOR);
        else
            score.setStyle(HIGH_COLOR);
    }
}
