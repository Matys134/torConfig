module com.example.torconfig {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.torconfig to javafx.fxml;
    exports com.example.torconfig;
}