package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private PasswordField passwort;

    @FXML
    private Button registrierenButton;

    @FXML
    private TextField benutzername;

    @FXML
    void registrieren(ActionEvent event) {
    		System.out.println("Benutzername: "+benutzername.getText().toString());
    		System.out.println("Passwort: "+passwort.getText().toString());
    }

}
