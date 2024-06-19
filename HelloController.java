package com.example.test1b;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {

    // Static credentials for testing
    private static final String STATIC_FIRSTNAME = "John";
    private static final String STATIC_LASTNAME = "Cena";
    private static final String STATIC_PASSWORD = "123";

    @FXML
    private TextField Firstname;

    @FXML
    private TextField Lastname;

    @FXML
    private PasswordField Password;

    private int loginAttempts = 0;
    private boolean accountLocked = false;

    @FXML
    public void initialize() {
        // Initialization logic if needed
    }

    @FXML
    protected void onHelloButtonClick() {
        if (accountLocked) {
            showAlert("Sorry, Your Account is Locked!!!");
            return;
        }

        String firstname = Firstname.getText().trim();
        String lastname = Lastname.getText().trim();
        String password = Password.getText().trim();

        // Perform static first name, last name, and password check
        if (firstname.equals(STATIC_FIRSTNAME) && lastname.equals(STATIC_LASTNAME) && password.equals(STATIC_PASSWORD)) {
            showAlert("Success!!!");
        } else {
            loginAttempts++;
            if (loginAttempts >= 5) {
                accountLocked = true;
                showAlert("Sorry, Your Account is Locked!!!");
            } else {
                showAlert("Please Provide Username or Password.");
            }
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Result");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
