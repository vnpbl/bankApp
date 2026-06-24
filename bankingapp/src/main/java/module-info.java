module com.gabriel.twoforms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gabriel.twoforms to javafx.fxml;
    exports com.gabriel.twoforms;
}