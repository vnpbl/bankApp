module com.gabriel.twoforms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.gabriel.twoforms to javafx.fxml;
    exports com.gabriel.twoforms;
}