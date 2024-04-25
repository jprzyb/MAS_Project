package pl.pjatk.mas.s24512.masproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.pjatk.mas.s24512.masproject.LoginUtils.Login;

public class LoginController {
    @FXML
    private Label loginLabel;
    @FXML
    private Label passLabel;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passField;
    @FXML
    private Label infoLabel;

    @FXML
    protected void onLoginButtonClick() {
        if(loginField.getText().equals("") || passField.getText().equals("")){
            infoLabel.setText("Enter login and password!");
        } else if (loginField.getText().equals("")) {
            infoLabel.setText("Enter a password!");
        } else if (passField.getText().equals("")) {
            infoLabel.setText("Enter a password!");
        }else {
            infoLabel.setText(Login.tryToLogin(loginField.getText(), passField.getText()));
        }

    }
}