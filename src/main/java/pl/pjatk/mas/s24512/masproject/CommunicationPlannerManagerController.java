package pl.pjatk.mas.s24512.masproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pl.pjatk.mas.s24512.masproject.DBUtils.Employees;
import pl.pjatk.mas.s24512.masproject.Repository.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class CommunicationPlannerManagerController extends CommunicationPlannerController implements Initializable {

    @FXML
    ListView<Employee> employeeList;
    @FXML
    Button setSalaryButton;
    @FXML
    Button setAnnualBonusButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
            employeeList.getItems().removeAll(employeeList.getItems());
            employeeList.getItems().addAll(Employees.getSubordinates(Util.loggedOnEmployee.getId()));
        }
    }

    public void afterEmployeeSalaryChangeClose(){
        loadEmployeeList();
        setSalaryButton.setDisable(false);
    }

    public void afterAnnualBonusChangeClose(){
        setAnnualBonusButton.setDisable(false);
    }
}
