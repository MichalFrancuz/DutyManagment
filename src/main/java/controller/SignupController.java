package controller;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

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

        signUpButton.setOnAction(actionEvent -> {
            createUser();
        });

    }

    private void createUser() {

        DatabaseHandler databaseHandler = new DatabaseHandler();

        String name = signUpFirstName.getText();
        String lastName = signUpLastName.getText();
        String userName = SignUpUsername.getText();
        String password = signUpPassword.getText();
        String location = signUpLocation.getText();

        String gender;
        if (signUpCheckboxeMale.isSelected()) {
            gender = "Male";
        } else gender = "Female";

        User user = new User(name, lastName, userName, password, location, gender);

        databaseHandler.signUpUser(user);
    }
}
