package com.gabriel.twoforms;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class CustomerController {

    @FXML private TextField accNumField;
    @FXML private TextField amountField;
    @FXML private Label messageLabel;

    @FXML
    public void handleDeposit(ActionEvent event) {
        try {
            int accNum = Integer.parseInt(accNumField.getText());
            double amount = Double.parseDouble(amountField.getText());

            Account acc = Bank.getAccount(accNum);
            if (acc != null) {
                acc.deposit(amount);

                Bank.updateBalance(accNum, acc.getBalance());

                messageLabel.setText("Successfully deposited: $" + amount);
            } else {
                messageLabel.setText("Account not found.");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Please enter valid numbers.");
        }
    }

    @FXML
    public void handleWithdraw(ActionEvent event) {
        try {
            int accNum = Integer.parseInt(accNumField.getText());
            double amount = Double.parseDouble(amountField.getText());

            Account acc = Bank.getAccount(accNum);
            if (acc != null) {
                if(amount > 0 && amount <= acc.getBalance()){
                    acc.withdraw(amount);

                    Bank.updateBalance(accNum, acc.getBalance());

                    messageLabel.setText("Successfully withdrew: $" + amount);
                } else {
                    messageLabel.setText("Insufficient funds.");
                }
            } else {
                messageLabel.setText("Account not found.");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Please enter valid numbers.");
        }
    }

    @FXML
    public void handleBalance(ActionEvent event) {
        try {
            int accNum = Integer.parseInt(accNumField.getText());
            Account acc = Bank.getAccount(accNum);
            if (acc != null) {
                messageLabel.setText("Current Balance: $" + acc.getBalance());
            } else {
                messageLabel.setText("Account not found.");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Please enter a valid account number.");
        }
    }

    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("role-selection.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void exitClick(ActionEvent actionEvent) {
        Platform.exit();
    }
}