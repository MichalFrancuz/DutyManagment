package controller;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Task;

import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddItemFormController {
    private int userId;
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
    private JFXButton myTuskButton;

    @FXML
    private Label successLabel;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        System.out.println(this.userId);
    }

    @FXML
    void initialize() {

        databaseHandler = new DatabaseHandler();

        saveTaskButton.setOnAction(actionEvent -> {

            Task task = new Task();

            Calendar calendar = Calendar.getInstance();

            java.sql.Timestamp timestamp = new java.sql.Timestamp(calendar.getTimeInMillis());

            String taskText = taskField.getText().trim();
            String taskDescription = descriptionField.getText().trim();

            if (!taskText.equals("") || !taskDescription.equals("")) {

                System.out.println("User ID: " + AddItemController.userId);

                task.setUserId(AddItemController.userId);
                task.setDatecreated(timestamp);
                task.setTask(taskText);
                task.setDescription(taskDescription);

                databaseHandler.insertTask(task);

                successLabel.setVisible(true);
                myTuskButton.setVisible(true);

                int taskNumber;
                try {
                    taskNumber = databaseHandler.getAllTasks(AddItemController.userId);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                myTuskButton.setText("My Tasks number: " + taskNumber);

                taskField.setText("");
                descriptionField.setText("");

                myTuskButton.setOnAction(actionEvent1 -> {

                });

                System.out.println("Task added successfully");

            } else {
                System.out.println("Nothing added");
            }

        });

    }
}
