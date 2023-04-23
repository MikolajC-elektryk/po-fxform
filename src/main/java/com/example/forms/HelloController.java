package com.example.forms;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    protected void onHelloButtonClick() {

        String login = loginTextField.getText();
        String passwd = passwordTextField.getText();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login status");



        if (passwd.isBlank() || login.isBlank()) {
            welcomeText.setText("Incomplete login data");
            alert.setHeaderText("Incomplete login data");

            if (passwd.isBlank() && login.isBlank())
                alert.setContentText("Put in valid data");
            else if (passwd.isBlank())
                alert.setContentText("Provide a password");
            else
                alert.setContentText("Provide a login");

        } else if (passwd.equals("123") && login.equals("admin")) {
            alert.setAlertType(Alert.AlertType.INFORMATION);
            welcomeText.setText("Logged in");
            alert.setHeaderText("Logged in");
            alert.setContentText("Congratulations");
        } else {
            welcomeText.setText("Invalid credentials");
            alert.setHeaderText("Invalid credentials");
            alert.setContentText("Check your credentials twice");
        }


         alert.showAndWait().ifPresent(rs -> {
         if (rs == ButtonType.OK && alert.getAlertType() == Alert.AlertType.INFORMATION) {
             HelloApplication.getInstance().switchScene("user-panel.fxml", String.format("Hello %s!", login), 720, 480);
         }
         });

    }
}