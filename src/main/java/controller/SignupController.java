package controller;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SignUpUsername;

    @FXML
    private JFXButton signUpButton;

    @FXML
    private JFXCheckBox signUpCheckboxFemale;

    @FXML
    private JFXCheckBox signUpCheckboxeMale;

    @FXML
    private TextField signUpFirstName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpLocation;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    void initialize() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        signUpButton.setOnAction(actionEvent -> databaseHandler.signUpUser(signUpFirstName.getText(), signUpLastName.getText(),
                SignUpUsername.getText(), signUpPassword.getText(),
                signUpLocation.getText(), "Female"));
    }
}
