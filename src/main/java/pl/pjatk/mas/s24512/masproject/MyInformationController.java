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
import pl.pjatk.mas.s24512.masproject.DBUtils.Employees;

import java.net.URL;
import java.util.ResourceBundle;

public class MyInformationController implements Initializable {
    @FXML
    TextField firstNameField;
    @FXML
    TextField roleField;
    @FXML
    TextField loginField;
    @FXML
    TextField passwordField;
    @FXML
    Label passInfoLabel;
    @FXML
    TextField managerField;
    @FXML
    TextField birthDateField;
    @FXML
    TextField employmentDateField;
    @FXML
    TextField salaryBaseField;
    @FXML
    TextField salaryFinalField;
    @FXML
    TextField levOfEduField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameField.setText(Util.loggedOnEmployee.getFirstName() + " " + Util.loggedOnEmployee.getLastName());
        roleField.setText(Util.loggedOnEmployee.getRole());
        loginField.setText(Util.loggedOnEmployee.getLogin());
        passwordField.setText(Util.loggedOnEmployee.getPassword());
        try{
            managerField.setText(Employees.getEmployeeById(Util.loggedOnEmployee.getManagerId()).toString());
        }catch (Exception e){
            managerField.setText("You are your own boss.");
        }
        birthDateField.setText(String.valueOf(Util.loggedOnEmployee.getBirthDate()));
        employmentDateField.setText(String.valueOf(Util.loggedOnEmployee.getEmploymentDate()));
        salaryBaseField.setText(String.valueOf(Util.loggedOnEmployee.getSalary()));
        salaryFinalField.setText(String.valueOf(
                Employees.getFactoryForEduLevel(Util.loggedOnEmployee.getLevelOfEducation()) * Util.loggedOnEmployee.getSalary()
        ));
        levOfEduField.setText(String.valueOf(
                Util.loggedOnEmployee.getLevelOfEducation()
        ));

    }

    public static void showMyInformation(PlannerViewController parent){
        try {
            FXMLLoader loader = new FXMLLoader(MyInformationController.class.getResource("my-information-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("My information");
            stage.show();
            stage.setOnHiding((windowEvent -> parent.afterMyInfoClose()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onOkClick(ActionEvent event){
        Stage  stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void setPassword(){
        if(Employees.setPassword(passwordField.getText(), Util.loggedOnEmployee.getId())) {
            passInfoLabel.setText("Done");
            Util.setLoggedOnEmployee(Employees.getEmployeeByLogin(loginField.getText()));
        }
        else passInfoLabel.setText("ERROR");
    }
}
