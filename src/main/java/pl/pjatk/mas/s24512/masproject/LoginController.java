package pl.pjatk.mas.s24512.masproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;
import pl.pjatk.mas.s24512.masproject.DBUtils.Login;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    TextField loginField;
    @FXML
    PasswordField passField;
    @FXML
    Label infoLabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void login(){
        if(!Login.tryToLogin(loginField.getText(), passField.getText())){
            infoLabel.setText("Invalid cridentials!");
        }
    }
}