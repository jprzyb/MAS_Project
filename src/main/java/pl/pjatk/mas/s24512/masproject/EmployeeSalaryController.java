package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.pjatk.mas.s24512.masproject.DBUtils.Employees;
import pl.pjatk.mas.s24512.masproject.Repository.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeSalaryController implements Initializable {
    public static boolean isShown = false;
    public static Employee employee;
    @FXML
    TextField employeeSalaryField;
    @FXML
    Label infoLabel;
    @FXML
    Label nameLabel;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(nameLabel.getText() + employee);
        employeeSalaryField.setText(String.valueOf(employee.getSalary()));
    }

    public static void showEmployeeSalaryWindow(Employee selectedEmployee, CommunicationPlannerManagerController parent){
        if(isShown) return;
        employee = selectedEmployee;
        try {
            FXMLLoader loader = new FXMLLoader(MyInformationController.class.getResource("employee-salary-change.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Employee salary change");
            stage.show();
            stage.setOnHiding((WindowEvent e) -> parent.afterEmployeeSalaryChangeClose());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onSetButtonClick(ActionEvent event){
        boolean flag = false;
        if(isDouble(employeeSalaryField.getText())) {
            flag = Employees.setSalary(Double.parseDouble(employeeSalaryField.getText()), employee.getId());
            if (!flag) infoLabel.setText("Something went wrong!");
            else onCancelButtonClick(event);
        }

        else infoLabel.setText("Wrong bonus value (should be like 1234.99)");
    }

    @FXML
    private void onCancelButtonClick(ActionEvent event){
        isShown = false;
        employee = null;
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    private boolean isDouble(String value) {
        if (value == null || value.isEmpty()) return false;
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
