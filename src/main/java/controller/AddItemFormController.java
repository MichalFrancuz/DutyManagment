package controller;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Task;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddItemFormController {
    private DatabaseHandler databaseHandler;
    @FXML
    public TextField taskField;
    @FXML
    public TextField descriptionField;
    @FXML
    public JFXButton saveTaskButton;
    public AnchorPane rootPane;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    void initialize() {

        databaseHandler = new DatabaseHandler();

        saveTaskButton.setOnAction(actionEvent -> {

            Task task = new Task();

            Calendar calendar = Calendar.getInstance();

            java.sql.Timestamp timestamp = new java.sql.Timestamp(calendar.getTimeInMillis());

            task.setDatecreated(timestamp);
            task.setDescription("First task");
            task.setTask("Finish Duty Management App");
            databaseHandler.insertTask(task);

        });

    }
}
