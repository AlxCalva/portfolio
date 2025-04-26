module com.example.projectpdi {
    requires javafx.controls;
    requires javafx.fxml;


    opens GUI to javafx.fxml;
    exports GUI;
}