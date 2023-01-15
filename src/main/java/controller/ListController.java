package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
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
    private JFXListView<String> listTask;

    @FXML
    private TextField listTaskField;

    @FXML
    private AnchorPane rootPane;
    ObservableList<String> listview = FXCollections.observableArrayList(
            "Work",
            "Study",
            "Programming",
            "Home",
            "example",
            "example",
            "example",
            "example",
            "example",
            "example",
            "example",
            "example",
            "example"
    );

    @FXML
    void initialize() {

        listTask.setItems(listview);

    }
}
