package com.example.forms;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class UserPanelController {

    @FXML
    private Label messageText;

    @FXML
    private void buttonClicked() {
        String[] messages = {"Mega click", "gigachad", "NICE!", "tres bien", "you are a monster", "you'd batter care about your back","WATCH OUT, BEHIND","ohh, you're sneaky"};

        Random rand = new Random();
        String msg = messages[rand.nextInt(0,messages.length)];
        messageText.setText(msg);
    }
}
