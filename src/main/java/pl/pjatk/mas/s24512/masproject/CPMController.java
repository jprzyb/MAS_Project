package pl.pjatk.mas.s24512.masproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pl.pjatk.mas.s24512.masproject.Models.CommunicationPlanner;

import java.net.URL;
import java.util.ResourceBundle;

public class CPMController extends CPController implements Initializable {
    @FXML
    ListView<CommunicationPlanner> subordinates;
    @FXML
    Button setSalaryButton;

    @FXML
    Button setAnnualBonusButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url,resourceBundle);
        loadEmployeeList();
    }

    @FXML
    private void showAnnualBonusView(){
        setAnnualBonusButton.setDisable(true);
        ABController.showAnnualBonusWindow(this);
    }

    @FXML
    private void setEmployeeSalary(){
        if (subordinates.getSelectionModel().getSelectedItem() != null){
            setSalaryButton.setDisable(true);
            ESController.showEmployeeSalaryWindow(subordinates.getSelectionModel().getSelectedItem(), this);
        }
    }

    private void loadEmployeeList() {
        if (subordinates != null){
            subordinates.getItems().removeAll(subordinates.getItems());
        }
        subordinates.getItems().addAll(Util.getSubordinatesByManager(Util.getCommunicationPlannerManagerById(Util.LOGGED_ON_ID)));
    }

    public void afterEmployeeSalaryChangeClose(){
        loadEmployeeList();
        setSalaryButton.setDisable(false);
    }

    public void afterAnnualBonusChangeClose(){
        setAnnualBonusButton.setDisable(false);
    }
}
