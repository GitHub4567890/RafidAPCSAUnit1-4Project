package com.example.rafidapcsaunit14project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class BudgetTrackerApplication extends Application {

    private static Stage stg;

    /* Takes in the stage info and creates the stage with the appropriate dimensions, beginning scene, and title. */
    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        primaryStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(BudgetTrackerApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 550);
        primaryStage.setTitle("Budget Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /* Takes in the FXML file name from the parameter and changes the scene to that of the name. */
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    /* Main class program launch with print debug statements. */
    public static void main(String[] args) {
        System.out.println("Starting Application...\nApplication Opened...");
        launch(args);
        System.out.println("Closed Application");
    }
}