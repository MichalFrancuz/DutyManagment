package controller;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Task;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ListController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField listDescriptionField;
    @FXML
    private JFXButton listSaveTaskButton;
    @FXML
    private JFXListView<Task> listTask;
    @FXML
    private TextField listTaskField;
    @FXML
    private AnchorPane rootPane;

    @FXML
    void initialize() throws SQLException {

        ObservableList<Task> tasks = FXCollections.observableArrayList();

        DatabaseHandler databaseHandler = new DatabaseHandler();
        ResultSet resultSet = databaseHandler.getTaskByUser(AddItemController.userId);

        while (resultSet.next()) {
            Task task = new Task();
            task.setTask(resultSet.getString("task"));
            task.setDatecreated(resultSet.getTimestamp("datecreated"));
            task.setDescription(resultSet.getString("description"));

            tasks.addAll(task);

//            System.out.println("User tasks: " + resultSet.getString("task"));
        }

        listTask.setItems(tasks);
        listTask.setCellFactory(CellController -> new CellController());

    }

}
