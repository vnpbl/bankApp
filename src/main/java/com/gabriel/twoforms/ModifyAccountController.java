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

public class ModifyAccountController {
    @FXML private TextField accNumField;
    @FXML private TextField newOwnerField;
    @FXML private Label messageLabel;

    public void handleModify(ActionEvent event) {
        try {
            int accNum = Integer.parseInt(accNumField.getText());
            String newOwner = newOwnerField.getText();

            if (newOwner.isEmpty()) {
                messageLabel.setText("Name cannot be empty.");
                return;
            }

            boolean success = Bank.modifyAccount(accNum, newOwner);
            if (success) {
                messageLabel.setText("Account updated successfully.");
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