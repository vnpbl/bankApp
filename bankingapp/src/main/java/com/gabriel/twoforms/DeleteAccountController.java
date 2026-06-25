package com.gabriel.twoforms;

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

public class DeleteAccountController {
    @FXML private TextField accNumField;
    @FXML private Label messageLabel;

    public void handleDelete(ActionEvent event) {
        try {
            int accNum = Integer.parseInt(accNumField.getText());
            boolean success = Bank.deleteAccount(accNum);

            if (success) {
                messageLabel.setText("Account deleted successfully.");
            } else {
                messageLabel.setText("Account not found.");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid Account Number.");
        }
    }

    public void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin-dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}