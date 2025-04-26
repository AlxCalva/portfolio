module com.example.digimpro {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.digimpro to javafx.fxml;
    exports com.example.digimpro;
}