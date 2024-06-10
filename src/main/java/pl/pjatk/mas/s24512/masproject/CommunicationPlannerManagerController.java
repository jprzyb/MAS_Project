package pl.pjatk.mas.s24512.masproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pl.pjatk.mas.s24512.masproject.DBUtils.AnnualBonuses;
import pl.pjatk.mas.s24512.masproject.DBUtils.Campaigns;
import pl.pjatk.mas.s24512.masproject.DBUtils.Employees;
import pl.pjatk.mas.s24512.masproject.Repository.CommunicationPlannerManager;
import pl.pjatk.mas.s24512.masproject.Repository.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class CommunicationPlannerManagerController extends CommunicationPlannerController implements Initializable {

    @FXML
    protected ListView<Employee> employeeList;
    @FXML
    protected Button setSalaryButton;
    @FXML
    protected Button setAnnualBonusButton;
    private CommunicationPlannerManager communicationPlannerManager;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        communicationPlannerManager = new CommunicationPlannerManager(Util.loggedOnEmployee, Campaigns.getCampaignsForPlannerWithId(Util.loggedOnEmployee.getId()),Employees.getSubordinates(Util.loggedOnEmployee.getId()));
        loadEmployeeList();
        super.initialize(url,resourceBundle);
    }

    @FXML
    private void showAnnualBonusView(){
        setAnnualBonusButton.setDisable(true);
        AnnualBonusChangeController.showAnnualBonusWindow(this);
    }

    @FXML
    private void setEmployeeSalary(){
        if (employeeList.getSelectionModel().getSelectedItem() != null){
            setSalaryButton.setDisable(true);
            EmployeeSalaryController.showEmployeeSalaryWindow(
                    employeeList.getSelectionModel().getSelectedItem(), this);
        }
    }

    private void loadEmployeeList() {
        if (employeeList != null){
            communicationPlannerManager.setEmployeeList(Employees.getSubordinates(communicationPlannerManager.getId()));
            employeeList.getItems().removeAll(employeeList.getItems());
            employeeList.getItems().addAll(communicationPlannerManager.getEmployeeList());
        }
    }

    public void afterEmployeeSalaryChangeClose(){
        loadEmployeeList();
        setSalaryButton.setDisable(false);
    }

    public void afterAnnualBonusChangeClose(){
        communicationPlannerManager.setAnnualBonus(AnnualBonuses.getAnnualBonusForPlanners());
        setAnnualBonusButton.setDisable(false);
    }
}
