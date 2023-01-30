package controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateTaskController {

    @FXML
    private TextField updateDescriptionField;
    @FXML
    private JFXButton updateTaskButton;
    @FXML
    private TextField updateTaskField;

    @FXML
    void initialize

    public JFXButton getUpdateTaskButton() {
        return updateTaskButton;
    }

    public void setUpdateTaskButton(JFXButton updateTaskButton) {
        this.updateTaskButton = updateTaskButton;
    }

    public void setUpdateTaskField(TextField updateTaskField) {
        this.updateTaskField.getText().trim();
    }

    public String getTask() {
        return this.updateTaskField.getText().trim();
    }

    public void setUpdateDescriptionField(String description) {
        this.updateDescriptionField.getText().trim();
    }

    public String getDescription() {
        return this.updateDescriptionField.getText().trim();
    }
    public void refreshList() throws SQLException {

        System.out.println("Calling refresh list");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/dutymanagement/list.fxml"));

        try {
            loader.load();

            ListController listController = loader.getController();
            listController.refreshList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
