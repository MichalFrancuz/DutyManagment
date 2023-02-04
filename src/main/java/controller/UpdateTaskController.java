package controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateTaskController {

    public TextField listTaskField;
    public TextField listDescriptionField;
    public JFXButton listSaveTaskButton;
    @FXML
    private TextField updateDescriptionField;
    @FXML
    public JFXButton updateTaskButton;
    @FXML
    private TextField updateTaskField;

    @FXML
    void initialize() {


    }

    public void setTaskField(String task) {
        this.updateTaskField.setText(task);
    }

    public String getTask() {
        return this.updateTaskField.getText().trim();
    }

    public void setUpdateDescriptionField(String description) {
        this.updateDescriptionField.setText(description);
    }

    public String getDescription() {
        return this.updateDescriptionField.getText().trim();
    }
}
