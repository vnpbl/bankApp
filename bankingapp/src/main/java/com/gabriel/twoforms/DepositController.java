package com.gabriel.twoforms;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DepositController {
    @javafx.fxml.FXML
    private TextField accNum;
    @javafx.fxml.FXML
    private Button btnSubmit;
    @javafx.fxml.FXML
    private TextField depAmt;

    @javafx.fxml.FXML
    public void OnDepositSubmit(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("transaction-view.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Scene scene = new Scene(root);
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        Bank.deposit(Double.parseDouble(depAmt.getText()),Integer.parseInt(accNum.getText()));




    }


}
