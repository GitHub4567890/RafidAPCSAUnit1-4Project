package com.example.rafidapcsaunit14project;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BudgetTrackerCalculator {
    private TextField startValue;
    private Label errorText;
    private int userCurrentValue;
    private String userExpense;

    /* Constructors all set the parameter values to a variable in the class. */
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

    /* Checks the startValue TextField from the constructor and returns a
    string with the number if it is an int and is positive,
    otherwise, it returns “error” and advises the user to round the value up or down. */
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

    /* Matches the username entered and password entered with ABC123
    (not case-sensitive using toLowerCase()) and 123ABC (case sensitive). */
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

    /* Uses substring to check the + or - symbol entered
    and adds the entered value from the constructor. */
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

    /* Uses Math.sqrt() to calculate the number of times to be
    the same as the number of payments for splittingValue. */
    public int splitValueIntoEqualPayments(int splittingValue) {
        return (int) Math.round(Math.sqrt(splittingValue));
    }

    /* Subtracts the monthly subscriptions and adds the monthly incomes using
    a while loop and % 30 to until the user entered days passed value is met. */
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

    /* Formats the return of the class if called. */
    public String toString() {
        return "userCurrentValue = " + userCurrentValue;
    }
}
