package com.example.forms;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage m_applicationStage;
    private static HelloApplication s_applicationRef;

    @Override

    public void start(Stage stage) throws IOException {
        s_applicationRef = this;
        m_applicationStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void switchScene(String fxmlFile, String title, double width, double height) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
            Scene scene = new Scene(fxmlLoader.load(), width, height);
            m_applicationStage.setTitle(title);
            m_applicationStage.setScene(scene);
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static HelloApplication getInstance() {
        return s_applicationRef;
    }

}