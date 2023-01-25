package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

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

        listTask.setCellFactory(param -> new JFXCell());

    }

    static class JFXCell extends JFXListCell<String> {
        //Hbox = Horizontal Box
        HBox hBox = new HBox();
        Button helloButton = new Button("Ok");
        Label task = new Label();

        Pane pane = new Pane();

        Image icon = new Image("file:src/main/resources/com/example/dutymanagement/assets/icons8-add-new-64.png");
        ImageView iconImg = new ImageView(icon);

        public JFXCell() {
            super();

            hBox.getChildren().addAll(iconImg, task, helloButton);
            HBox.setHgrow(pane, Priority.ALWAYS);
        }

        public void updateItem(String taskName, boolean empty) {
            super.updateItem(taskName, empty);
            setText(null);
            setGraphic(null);

            if (taskName != null && !empty) {
                task.setText(taskName);
                setGraphic(hBox);
            }
        }
    }

}
