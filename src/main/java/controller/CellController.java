package controller;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Task;

import java.io.IOException;
import java.sql.SQLException;

public class CellController extends JFXListCell<Task> {

    @FXML
    private Label dateLabel;

    @FXML
    private ImageView deleteButton;

    @FXML
    private Label descriptionLabel;

    @FXML
    private ImageView iconImageView;

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private Label taskLabel;

    private FXMLLoader fxmlLoader;

    private DatabaseHandler databaseHandler;

    @FXML
    void initialize() {


    }

    @Override
    protected void updateItem(Task myTask, boolean empty) {
        super.updateItem(myTask, empty);

        if (empty || myTask == null) {
            setText(null);
            setGraphic(null);
        } else {

            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource("/com/example/dutymanagement/cell.fxml"));
                fxmlLoader.setController(this);

                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            taskLabel.setText(myTask.getTask());
            dateLabel.setText(myTask.getDatecreated().toString());
            descriptionLabel.setText(myTask.getDescription());

            int taskId = myTask.getTaskId();

            deleteButton.setOnMouseClicked(mouseEvent -> {
                databaseHandler = new DatabaseHandler();
                try {
                    databaseHandler.deleteTask(AddItemController.userId, taskId);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                getListView().getItems().remove(getItem());

            });

            setText(null);
            setGraphic(rootAnchorPane);

        }
    }
}
