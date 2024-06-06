package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PlannerViewController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void logout(ActionEvent event){
        LoginController.setToLogOffScene(event);
    }

    @FXML
    private void showMyInformation(){
        MyInformationController.showMyInformation();
    }
}
