package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.pjatk.mas.s24512.masproject.Models.enums.RoleType;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
    private void login(ActionEvent event){
//        System.out.println("Logging in by: " + loginField.getText() + " " + passField.getText());
        if(!Util.validateLogin(loginField.getText(), passField.getText())){
            infoLabel.setText("Invalid cridentials!");
            return;
        }
        String loggedOnId = Util.getEmployeeIdByLogin(loginField.getText());
//        System.out.println(loggedOnId);
        if(loggedOnId.isEmpty()) {
            infoLabel.setText("Not implemented yet");
            return;
        }
        Util.LOGGED_ON_ROLE = Util.getRoleById(loggedOnId);

        changeView(event);
    }

    private void changeView(ActionEvent event){
        String viewType = "NONE";
        if(Util.LOGGED_ON_ROLE.equals(RoleType.COMMUNICATION_PLANNER)) viewType = "planner-view.fxml";
        else viewType = "planner-manager-view.fxml";

        Stage stage;
        Scene scene;
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource(viewType)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setOnHiding((WindowEvent) -> Util.saveData());
        stage.show();
    }


    public static void setToLogOffScene(ActionEvent event){
        Stage stage;
        Scene scene;
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("login-view.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setOnHiding((WindowEvent) -> Util.saveData());
        stage.show();
    }
}