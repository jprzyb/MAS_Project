package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<String> infoList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setInfoList();
    }
    @FXML
    private void switchToLoggedOffScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setInfoList(){
        infoList.getItems().add("id: "          +Util.loggedOn.getId());
        infoList.getItems().add("First name: "  +Util.loggedOn.getFirstName());
        infoList.getItems().add("Last name: "   +Util.loggedOn.getLastName());
        infoList.getItems().add("Login "        +Util.loggedOn.getLogin());
        infoList.getItems().add("Password: "    +Util.loggedOn.getPassword());
    }


}