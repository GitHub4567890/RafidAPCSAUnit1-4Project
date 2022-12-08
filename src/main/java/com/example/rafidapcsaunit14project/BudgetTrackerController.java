package com.example.rafidapcsaunit14project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class BudgetTrackerController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Label loginError;


    @FXML
    protected void onUserLoginClick() throws IOException {
        BudgetTrackerApplication BTA = new BudgetTrackerApplication();
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            System.out.println("User missing login info.");
            loginError.setText("Please enter your login info.");
        } else {
            String userN = username.getText().toString();
            String pass = password.getText().toString();

            BudgetTrackerCalculator loginCheck = new BudgetTrackerCalculator();

            if (loginCheck.checkLogin(userN, pass)) {
                loginError.setText("Success!");
                System.out.println("User entered" + " correct login info.");
                BTA.changeScene("trackerHomepage.fxml");
            } else {
                loginError.setText("I'm disappointed in you.");
            }
        }

    }
}