package com.example.rafidapcsaunit14project;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BudgetTrackerCalculator {
    private TextField startValue;
    private Label errorText;
    private int userCurrentValue;
    private String userExpense;

    public BudgetTrackerCalculator() {
    }

    public BudgetTrackerCalculator(TextField field, Label errorText) {
        startValue = field;
        this.errorText = errorText;
    }

    public BudgetTrackerCalculator(String expense, int currentValue) {
        userExpense = expense;
        userCurrentValue = currentValue;
    }

    public BudgetTrackerCalculator(int currentVal) {
        userCurrentValue = currentVal;
    }

    public String checkStartValue() {
        int userTotalStartValue;
        double userTotalStartValueError;
        if (!startValue.getText().contains("-")) {
            try {
                userTotalStartValue = Integer.parseInt(startValue.getText());
                System.out.println("User entered start total: " + userTotalStartValue);
                errorText.setText("");
                return Integer.toString(userTotalStartValue);
            } catch (Exception a) {
                try {
                    userTotalStartValueError = Double.parseDouble(startValue.getText());
                    System.out.println("User entered a double: " + userTotalStartValueError + " instead of int.");
                    if (Math.round(userTotalStartValueError) > userTotalStartValueError) {
                        errorText.setText("Please round the number up.");
                        return userTotalStartValueError + "error";
                    } else {
                        errorText.setText("Please round the number down.");
                        return userTotalStartValueError + "error";
                    }
                } catch (Exception b) {
                    errorText.setText("Please enter a value as an int.");
                    String errorText = startValue.getText();
                    System.out.println("User entered a String instead of an int: " + errorText);
                    return errorText;
                }
            }
        } else {
            return "error";
        }
    }


    public boolean checkLogin(String username, String password) {
        if (username.toLowerCase().equals("abc123") && password.equals("123ABC")) {
            return true;
        } else {
            String passLengthDashes = "";
            for (int i = 0; i < password.length(); i++) {
                passLengthDashes += "-";
            }
            String printError = "User entered wrong login info:\nUsername: " + username + "\nPassword: " + passLengthDashes;
            System.out.println(printError);
            return false;
        }
    }

    public String calculateTotalAfterExpense() {
        try {
            int expenseVal = (int) Math.round(Double.parseDouble(userExpense.substring(1)));
            System.out.println("User add: " + expenseVal + " to current value: " + userCurrentValue);
            String operation = userExpense.substring(0,1);
            if (operation.equals("+")) {
                return Integer.toString(userCurrentValue + expenseVal);
            } else if (operation.equals("-")) {
                return Integer.toString(userCurrentValue - expenseVal);
            } else {
                return "error";
            }
        } catch (Exception a) {
            return "error";
        }
    }

    public int splitValueIntoEqualPayments(int splittingValue) {
        return (int) Math.round(Math.sqrt(splittingValue));
    }

    public int calculateValueAfterDays(int monthlySub, int monthlyInc, int daysPassed) {
        int userCurrentValueTemp = userCurrentValue;
        int i = 1;
        while (i <= daysPassed) {
            if ((double) i % 30 == 0) {
                userCurrentValueTemp += monthlyInc;
                userCurrentValueTemp -= monthlySub;
            }
            i++;
        }
        System.out.println("User calculate value with current value: " + userCurrentValue + ", total monthly subscriptions: " + monthlySub + ", total monthly income: " + monthlyInc + ", and " + daysPassed + " days. " + "Result: " + userCurrentValueTemp);
        return userCurrentValueTemp;
    }

    public String toString() {
        return "userCurrentValue = " + userCurrentValue;
    }
}
