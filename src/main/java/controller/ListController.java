package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Task;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    void initialize() {

        Task myTask = new Task();
        myTask.setTask("Run 10 km");
        myTask.setDescription("Have to do it tomorrow morning");
        myTask.setDatecreated(Timestamp.valueOf(LocalDateTime.now()));

        Task myTask2 = new Task();
        myTask2.setTask("Sell my old car");
        myTask2.setDescription("Have to do it to 01.02.2023");
        myTask2.setDatecreated(Timestamp.valueOf(LocalDateTime.now()));

        ObservableList<Task> tasks = FXCollections.observableArrayList();

        tasks.addAll(myTask, myTask2);

        listTask.setItems(tasks);
        listTask.setCellFactory(CellController -> new CellController());

    }

}
