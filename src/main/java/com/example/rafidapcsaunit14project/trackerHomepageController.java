package com.example.rafidapcsaunit14project;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;


public class trackerHomepageController {
    @FXML
    private Button startHomepage;
    @FXML
    private TextField itemValue;
    @FXML
    private TextField monthlySub;
    @FXML
    private TextField monthlyInc;
    @FXML
    private TextField days;
    @FXML
    private TextField initialValueTextField;
    @FXML
    private TextField splittingPayment;
    @FXML
    private Button addToTotal;
    @FXML
    private Button viewTotal;
    @FXML
    private Button logOut2;
    @FXML
    private Button addExpErrorOkButton;
    @FXML
    private Button seeValueSplittingPayment;
    @FXML
    private Button splittingPaymentErrorButton;
    @FXML
    private Button monthlySubErrorOk;
    @FXML
    private Button monthlyIncomeErrorOk;
    @FXML
    private Button daysErrorOk;
    @FXML
    private Label initiallyEnteredTotalLabel;
    @FXML
    private Label currentTotalLabel;
    @FXML
    private Label totalViewText;
    @FXML
    private Label valueStartError;
    @FXML
    private Label errorAdd;
    @FXML
    private Label splittingPaymentLabel;
    @FXML
    private Label monthlyIncomeErrorLabel;
    @FXML
    private Label monthlySubErrorLabel;
    @FXML
    private Label daysErrorLabel;


    private int initialTotal;
    private int currentTotal;

    @FXML
    protected void onUserStartClick() {
        BudgetTrackerCalculator valueCheck = new BudgetTrackerCalculator(initialValueTextField, valueStartError);
        try {
            initialTotal = Integer.parseInt(valueCheck.checkStartValue());
            currentTotal = initialTotal;
            initialValueTextField.setVisible(false);
            startHomepage.setVisible(false);
            initiallyEnteredTotalLabel.setText("Initially Entered Total: " + initialTotal);
            currentTotalLabel.setText("Current Total: " + initialTotal);
        } catch (Exception ignored) {

        }
    }

    @FXML
    protected void onUserAddClick() {
        BudgetTrackerCalculator calculate = new BudgetTrackerCalculator(itemValue.getText(), currentTotal);
        String result = calculate.calculateTotalAfterExpense();
        if (!result.equals("error")) {
            currentTotal = Integer.parseInt(result);
            currentTotalLabel.setText("Current Total: " + currentTotal);
        } else {
            errorAdd.setText("Error");
            addExpErrorOkButton.setVisible(true);
            System.out.println("User add money error.");
        }

    }

    @FXML
    protected void onUserAddErrorOkClick() {
        addExpErrorOkButton.setVisible(false);
        errorAdd.setText("");
    }

    @FXML
    protected void onViewClick() {
        int monthlySubscription;
        int monthlyIncome;
        int numberOfDays;

        try {
            monthlySubscription = (int) Math.round(Double.parseDouble(monthlySub.getText()));
        } catch (Exception s) {
            monthlySubErrorLabel.setText("Error");
            monthlySubErrorOk.setVisible(true);
            monthlySubscription = 0;
        }

        try {
            monthlyIncome = (int) Math.round(Double.parseDouble(monthlyInc.getText()));
        } catch (Exception s) {
            monthlyIncomeErrorLabel.setText("Error");
            monthlyIncomeErrorOk.setVisible(true);
            monthlyIncome = 0;
        }

        try {
            numberOfDays = (int) Math.round(Double.parseDouble(days.getText()));
        } catch (Exception s) {
            daysErrorLabel.setText("Error");
            daysErrorOk.setVisible(true);
            return;
        }

        BudgetTrackerCalculator calculateValue = new BudgetTrackerCalculator(currentTotal);
        int result = calculateValue.calculateValueAfterDays(monthlySubscription, monthlyIncome, numberOfDays);
        totalViewText.setText("Your total after " + numberOfDays + " days will be " + result);

    }

    @FXML
    protected void onUserMonthlySubOkClick() {
        monthlySubErrorOk.setVisible(false);
        monthlySubErrorLabel.setText("");
    }

    @FXML
    protected void onUserMonthlyIncOkClick() {
        monthlyIncomeErrorOk.setVisible(false);
        monthlyIncomeErrorLabel.setText("");
    }

    @FXML
    protected void onUserDaysOkClick() {
        daysErrorOk.setVisible(false);
        daysErrorLabel.setText("");
    }

    @FXML
    protected void onUserLogOutClick2() throws IOException {
        BudgetTrackerApplication BTA2 = new BudgetTrackerApplication();
        BTA2.changeScene("hello-view.fxml");
        System.out.println("User logged out.");
    }

    @FXML
    protected void onUserSeeValueSplittingClick() {
        int splittingPaymentValue;
        int splittingPaymentValueResult;
        try {
            splittingPaymentValue = (int) Math.round(Double.parseDouble(splittingPayment.getText()));
            BudgetTrackerCalculator splitValue = new BudgetTrackerCalculator();
            splittingPaymentValueResult = splitValue.splitValueIntoEqualPayments(splittingPaymentValue);
            splittingPaymentLabel.setText("To cover " + splittingPaymentValue + ", you need to pay approximately " + splittingPaymentValueResult + " everyday for " + splittingPaymentValueResult + " days.");
            System.out.println("User entered split value " + splittingPaymentValue + ", result: " + splittingPaymentValueResult);
            splittingPaymentErrorButton.setVisible(false);
        } catch (Exception e) {
            splittingPaymentLabel.setText("Error");
            splittingPaymentErrorButton.setVisible(true);
            System.out.println("User split value error.");
        }
    }

    @FXML
    protected void onUserSplittingPaymentErrorButtonOkClick() {
        splittingPaymentErrorButton.setVisible(false);
        splittingPaymentLabel.setText("");
    }


}
