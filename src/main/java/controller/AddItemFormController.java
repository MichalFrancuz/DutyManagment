package controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemFormController {
    @FXML
    public TextField taskField;
    @FXML
    public TextField descriptionField;
    @FXML
    public JFXButton saveTaskButton;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    void initialize() {

    }
}
