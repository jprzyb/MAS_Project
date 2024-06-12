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
import pl.pjatk.mas.s24512.masproject.Models.CommunicationPlannerManager;
import pl.pjatk.mas.s24512.masproject.Models.EducationLevel;
import pl.pjatk.mas.s24512.masproject.Models.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class MIController implements Initializable {

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
        Employee e = Util.getEmployeeById(Util.LOGGED_ON_ID);
        firstNameField.setText(e.getFirstName() + " " + e.getLastName());
        roleField.setText(String.valueOf(Util.LOGGED_ON_ROLE));
        loginField.setText(e.getLogin());
        passwordField.setText(e.getPassword());
        CommunicationPlannerManager m = Util.getManagerBySubordinateId(e.getId());
        if(m == null) managerField.setText("N/A");
        else managerField.setText(m.getFirstName() + " " + m.getLastName());
        birthDateField.setText(String.valueOf(e.getBirthDate()));
        employmentDateField.setText(String.valueOf(e.getEmploymentDate()));
        salaryBaseField.setText(String.valueOf(e.getSalary()));
        salaryFinalField.setText(String.valueOf(e.getSalary() * e.getEducationLevel().getFactor()));
        levOfEduField.setText(String.valueOf(e.getEducationLevel().getEducationType()));
    }
    @FXML
    private void setPassword(){
        Util.getEmployeeById(Util.LOGGED_ON_ID).setPassword(passwordField.getText());
    }

    @FXML
    private void setLogin(){
        Util.getEmployeeById(Util.LOGGED_ON_ID).setLogin(loginField.getText());
    }
    @FXML
    private void onOkClick(ActionEvent event){
        Stage  stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public static void showMyInformation(CPController parent){
        try {
            FXMLLoader loader = new FXMLLoader(MIController.class.getResource("my-information-view.fxml"));
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
}
