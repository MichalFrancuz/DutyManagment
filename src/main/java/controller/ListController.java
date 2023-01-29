package controller;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Task;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.ResourceBundle;

public class ListController {
    @FXML
    private ImageView listRefreshButton;
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

    private DatabaseHandler databaseHandler;

    @FXML
    void initialize() throws SQLException {

        ObservableList<Task> tasks = FXCollections.observableArrayList();

        databaseHandler = new DatabaseHandler();
        ResultSet resultSet = databaseHandler.getTaskByUser(AddItemController.userId);

        while (resultSet.next()) {
            Task task = new Task();
            task.setTaskId(resultSet.getInt("taskid"));
            task.setTask(resultSet.getString("task"));
            task.setDatecreated(resultSet.getTimestamp("datecreated"));
            task.setDescription(resultSet.getString("description"));

            tasks.addAll(task);

        }

        listTask.setItems(tasks);
        listTask.setCellFactory(CellController -> new CellController());

        listRefreshButton.setOnMouseClicked(mouseEvent -> {
            try {
                refreshList();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        listSaveTaskButton.setOnAction(actionEvent -> addNewTask());

    }

    public void addNewTask() {

        if (!listTaskField.getText().equals("") ||
                !listDescriptionField.getText().equals("")) {
            Task myNewTask = new Task();

            Calendar calendar = Calendar.getInstance();

            Timestamp timestamp =
                    new Timestamp(calendar.getTimeInMillis());

            myNewTask.setUserId(AddItemController.userId);
            myNewTask.setTask(listTaskField.getText().trim());
            myNewTask.setDescription(listDescriptionField.getText().trim());
            myNewTask.setDatecreated(timestamp);

            databaseHandler.insertTask(myNewTask);

            listTaskField.setText("");
            listDescriptionField.setText("");

            try {
                initialize();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void refreshList() throws SQLException {

        System.out.println("refreshList in ListCont called");

        ObservableList<Task> refreshedTasks = FXCollections.observableArrayList();

        databaseHandler = new DatabaseHandler();
        ResultSet resultSet = databaseHandler.getTaskByUser(AddItemController.userId);

        while (resultSet.next()) {
            Task task = new Task();
            task.setTaskId(resultSet.getInt("taskid"));
            task.setTask(resultSet.getString("task"));
            task.setDatecreated(resultSet.getTimestamp("datecreated"));
            task.setDescription(resultSet.getString("description"));

            refreshedTasks.addAll(task);

        }
    }

}
