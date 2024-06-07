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
import pl.pjatk.mas.s24512.masproject.DBUtils.Employees;
import pl.pjatk.mas.s24512.masproject.DBUtils.EmployeesTypes;
import pl.pjatk.mas.s24512.masproject.DBUtils.Login;
import pl.pjatk.mas.s24512.masproject.Repository.Employee;

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
        if(Login.tryToLogin(loginField.getText(), passField.getText())){
            Employee e = Employees.getEmployeeByLogin(loginField.getText());
            Util.setLoggedOnEmployee(e);
            changeView(event);
        }
        else infoLabel.setText("Invalid cridentials!");
    }

    private void changeView(ActionEvent event){
        String viewType = "NONE";
        if(EmployeesTypes.IsCommunicationPlanner(Util.loggedOnEmployee.getId())) viewType = "planner-view.fxml";
        else if(EmployeesTypes.IsPlannerManager (Util.loggedOnEmployee.getId())) viewType = "planner-manager-view.fxml";
        else if(EmployeesTypes.IsTraffic (Util.loggedOnEmployee.getId())) viewType = "traffic-view.fxml";
        else if(EmployeesTypes.IsTrafficManager (Util.loggedOnEmployee.getId())) viewType = "traffic-manager-view.fxml";
        else if(EmployeesTypes.IsTrafficAIO (Util.loggedOnEmployee.getId())) viewType = "traffic-AIO-view.fxml";
        else if(EmployeesTypes.IsDesigner (Util.loggedOnEmployee.getId())) viewType = "designer-view.fxml";
        else if(EmployeesTypes.IsCampaignAccountant (Util.loggedOnEmployee.getId())) viewType = "campaign-accountant-view.fxml";
        else if(EmployeesTypes.IsCorporateAccountant (Util.loggedOnEmployee.getId())) viewType = "company-accountant-view.fxml";
        else if(EmployeesTypes.IsAccountantAIO (Util.loggedOnEmployee.getId())) viewType = "accountant-AIO-view.fxml";

        try {
            Stage stage;
            Scene scene;
            Parent root;
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(viewType)));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void setToLogOffScene(ActionEvent event){
        Util.setLoggedOnEmployee(null);
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
        stage.show();
    }
}