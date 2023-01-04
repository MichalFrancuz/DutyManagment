package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.stage.Stage;

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

        String loginText = loginUsername.getText().trim();
        String loginPwd = loginPassword.getText().trim();

        loginSignupButton.setOnAction(actionEvent -> {
            //Take users to signup screen
            loginSignupButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/dutymanagment/signup.fxml"));

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

        loginSigninButton.setOnAction(actionEvent -> {
            if (!loginText.equals("") || !loginPwd.equals("")) {
                loginUser(loginText, loginPwd);
            }else {
                System.out.println("Error login in user");
            }

        });
    }

    private void loginUser(String userName, String password) {
        //Check in the database if the user exists, if true
        //we take them to AddItem Screen
    }
}