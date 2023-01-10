package controller;

import animations.Shaker;
import com.example.dutymanagment.HelloApplication;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
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

    @FXML
    void initialize() {

        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                    Shaker buttonShaker = new Shaker(addButton);
                    buttonShaker.shake();

                    FadeTransition buttonTransition = new FadeTransition(Duration.millis(2500), addButton);
                    FadeTransition labelTransition = new FadeTransition(Duration.millis(2500), notTaskLabel);

                    System.out.println("Added button Clicked");
                    addButton.relocate(0, -80);
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

            addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                //Take users to signup screen
                addButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/example/dutymanagment/addItemForm.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();

            });

//            try {
//                AnchorPane formPane = FXMLLoader.load(getClass().getResource("/com/example/dutymanagment/addItem.fxml"));
//                rootPane.getChildren().setAll(formPane);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            // I can inherit elements from another window using just this method
            // This is exists and is worth to know but now I don't need this


    }
}
