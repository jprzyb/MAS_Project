package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pjatk.mas.s24512.masproject.BussinessUtils.Employee;
import pl.pjatk.mas.s24512.masproject.LoginUtils.Login;

import java.io.IOException;
import java.util.Objects;

import static pl.pjatk.mas.s24512.masproject.LoginUtils.Login.APPROVE_LOGIN_MSG;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passField;
    @FXML
    private Label infoLabel;
    @FXML
    protected void onSkipButtonClick(ActionEvent event) throws IOException {
        Util.setEmployeeLoggedOn(new Employee(0, "admin", "admin", "admin", "admin"));
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view-fixed.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToLoggedOnScene(ActionEvent event) throws IOException {
        if(loginField.getText().equals("") || passField.getText().equals("")){
            infoLabel.setText("Enter login and password!");
        } else if (loginField.getText().equals("")) {
            infoLabel.setText("Enter a password!");
        } else if (passField.getText().equals("")) {
            infoLabel.setText("Enter a password!");
        }else if(Login.tryToLogin(loginField.getText(), passField.getText()).equals(APPROVE_LOGIN_MSG)){
            infoLabel.setText(Login.tryToLogin(loginField.getText(), passField.getText()));
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view-fixed.fxml")));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        }
        infoLabel.setText("Wrong Cridentials!");
    }
}