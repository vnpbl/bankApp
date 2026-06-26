package com.gabriel.twoforms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class ShowAccountsController {

    @FXML private TableView<Account> table;
    @FXML private TableColumn<Account, Integer> account;
    @FXML private TableColumn<Account, String> name;
    @FXML private TableColumn<Account, Double> balance;

    @FXML
    public void initialize() {
        account.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        name.setCellValueFactory(new PropertyValueFactory<>("owner"));
        balance.setCellValueFactory(new PropertyValueFactory<>("balance"));

        ObservableList<Account> list = FXCollections.observableArrayList(Bank.getAllAccounts());
        table.setItems(list);
    }

    @FXML
    public void OnBackClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin-dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}