package com.gabriel.twoforms;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class CreateAccountController {

    private int accountNumber;
    @javafx.fxml.FXML
    private Button createSubmit;
    @javafx.fxml.FXML
    private TextField tf_name;
    @javafx.fxml.FXML
    private TextField acc_num;

    public TextField getAcc_num() {
        return acc_num;
    }

    public void setAcc_num(TextField acc_num) {
        this.acc_num = acc_num;
    }

    @javafx.fxml.FXML
    public void OnCreateSubmit(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("transaction-view.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Scene scene = new Scene(root);
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();


        Bank.createAccount(Integer.parseInt(acc_num.getText()),tf_name.getText());

//        for (Account acc: Bank.accounts) {
//            System.out.println(acc.getAccountNumber() + " " + acc.getOwner() + " " + acc.getBalance());
//        }
    }
}
