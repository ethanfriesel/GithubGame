package com.example.githubgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button myButton;
    @FXML
    private Button buttonA;
    @FXML
    private Button buttonB;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void buttonClicked(ActionEvent itemClicked){
        Button buttonClicked = (Button) itemClicked.getSource();
        welcomeText.setText(buttonClicked.getText());
    }
}