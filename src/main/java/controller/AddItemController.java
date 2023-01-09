package controller;

import animations.Shaker;
import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addButton;

    @FXML
    private Label notTaskLabel;

    @FXML
    void initialize() {

        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Shaker buttonShaker = new Shaker(addButton);
            buttonShaker.shake();

            FadeTransition buttonTransition = new FadeTransition(Duration.millis(2500), addButton);
            FadeTransition labelTransition = new FadeTransition(Duration.millis(2500), notTaskLabel);

            System.out.println("Added button Clicked");
            addButton.relocate(0, 0);
            notTaskLabel.relocate(0, 55);

            addButton.setOpacity(0);
            notTaskLabel.setOpacity(0);

            buttonTransition.setFromValue(1f);
            buttonTransition.setToValue(0f);
            buttonTransition.setCycleCount(2);
            buttonTransition.play();

            labelTransition.setFromValue(1f);
            labelTransition.setToValue(0f);
            labelTransition.setCycleCount(2);
            labelTransition.play();
        });

    }
}
