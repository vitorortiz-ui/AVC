module com.mycompany.avc {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.avc to javafx.fxml;
    opens controller to javafx.fxml;

    exports com.mycompany.avc;
    exports controller;
}
