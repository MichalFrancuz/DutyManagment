package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

public class LoginController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginPassword;

    @FXML
    private JFXButton loginSigninButton;

    @FXML
    private JFXButton loginSignupButton;

    @FXML
    private TextField loginUsername;

    @FXML
    void initialize() {
        loginSigninButton.setOnAction(actionEvent -> {
            System.out.println("Login Clicked");
        });
    }
}