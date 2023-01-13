package controller;

import animations.Fader;
import animations.Shaker;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddItemController {
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addButton;

    @FXML
    private Label notTaskLabel;
    public static int userId;

    @FXML
    void initialize() {

        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Shaker buttonShaker = new Shaker(addButton);
            buttonShaker.shake();

            System.out.println("Added button Clicked");
            addButton.relocate(0, -80);
            notTaskLabel.relocate(0, 55);

            addButton.setOpacity(0);
            notTaskLabel.setOpacity(0);

            Fader buttonTransitionFader = new Fader(addButton, 2500);
            buttonTransitionFader.fade();

            Fader labelTransitionFader = new Fader(notTaskLabel, 2500);
            labelTransitionFader.fade();

            try {
                AnchorPane formPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/dutymanagement/addItemForm.fxml")));

                AddItemController.userId = getUserId();

                Fader formPaneShaker = new Fader(formPane, 1000);
                formPaneShaker.fade();

                rootAnchorPane.getChildren().setAll(formPane); // I can inherit elements from another window using just this method
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public void setUserId(int userId) {
        AddItemController.userId = userId;
        System.out.println("User ID is " + AddItemController.userId);
    }

    public int getUserId() {
        return userId;
    }

}
