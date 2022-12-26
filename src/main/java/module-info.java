module com.example.dutymanagment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dutymanagment to javafx.fxml;
    exports com.example.dutymanagment;
    exports controller;
    opens controller to javafx.fxml;
}