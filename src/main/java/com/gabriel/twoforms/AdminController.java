package com.gabriel.twoforms;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class AdminController {

    public void goToCreateAccount(ActionEvent event) throws IOException {
        switchScene(event, "create-view.fxml");
    }

    public void goToViewAccounts(ActionEvent event) throws IOException {
        switchScene(event, "show_accounts-view.fxml");
    }

    public void goToModifyAccount(ActionEvent event) throws IOException {
        switchScene(event, "modify-account.fxml");
    }

    public void goToDeleteAccount(ActionEvent event) throws IOException {
        switchScene(event, "delete-account.fxml");
    }

    public void logout(ActionEvent event) throws IOException {
        switchScene(event, "role-selection.fxml");
    }

    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void exitClick(ActionEvent actionEvent) {
        Platform.exit();
    }
}