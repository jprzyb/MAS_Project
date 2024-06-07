package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.pjatk.mas.s24512.masproject.DBUtils.Clients;
import pl.pjatk.mas.s24512.masproject.DBUtils.Companies;
import pl.pjatk.mas.s24512.masproject.Repository.Client;
import pl.pjatk.mas.s24512.masproject.Repository.Company;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewClientController implements Initializable {
    @FXML
    TextField idField;
    @FXML
    TextField firstNameField;
    @FXML
    TextField lastNameField;
    @FXML
    TextField emailAddresField;
    @FXML
    TextField phoneNumberField;
    @FXML
    TextField companyNameField;
    @FXML
    TextField companyAdressField;
    @FXML
    TextField companyAccountNumberField;
    @FXML
    TextField companyIdField;
    @FXML
    ChoiceBox<Company> comapnyChoiceBox;
    @FXML
    CheckBox companyCheckBox;
    @FXML
    VBox companyVBOX;
    @FXML
    Label infoLabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idField.setText(String.valueOf(UUID.randomUUID()));
        companyIdField.setText(String.valueOf(UUID.randomUUID()));
        comapnyChoiceBox.getItems().addAll(Companies.getAllCompanies());
    }
    public static void showNewClientWindow(NewCampaignController parent){
        try {
            FXMLLoader loader = new FXMLLoader(MyInformationController.class.getResource("new-client-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("New Campaign");
            stage.show();
            stage.setOnHiding((WindowEvent event) -> parent.afterNewClientClose());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onSaveButtonClick(ActionEvent event){
        String validation = validateInput();
        boolean flag = false;

        if (validation.equals("true")){
            if (companyCheckBox.isSelected()){
                flag = Companies.insertCompany(
                        new Company(companyIdField.getText(),companyNameField.getText(),companyAdressField.getText(),companyAccountNumberField.getText().trim(), false)
                );
                flag = Clients.insertClient(
                        new Client(idField.getText(), firstNameField.getText(), lastNameField.getText(), emailAddresField.getText(), phoneNumberField.getText(), companyIdField.getText())
                );
            }
            else {
                flag = Clients.insertClient(
                        new Client(idField.getText(), firstNameField.getText(), lastNameField.getText(), emailAddresField.getText(), phoneNumberField.getText(), comapnyChoiceBox.getSelectionModel().getSelectedItem().getId())
                );
            }
            onCancelButtonClick(event);
        }else infoLabel.setText(validation);
    }
    @FXML
    private void onCancelButtonClick(ActionEvent event){
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    private String validateInput(){
        if (idField.getText().isEmpty()) return "Client ID field is empty!";
        else if (firstNameField.getText().isEmpty()) return "Client first name field is empty!";
        else if (lastNameField.getText().isEmpty()) return "Client last name field is empty!";
        else if (emailAddresField.getText().isEmpty()) return "Client E-mail adress field is empty!";
        else if (!isEmail(emailAddresField.getText())) return "Invalid client E-mail adress!";
        else if (phoneNumberField.getText().isEmpty()) return "Client phone number field is empty!";
        else if (!isInteger(phoneNumberField.getText())) return "Invalid client phone number!";
        else if (Integer.parseInt(phoneNumberField.getText()) < 100000000) return "Invalid client phone number! (try 111000111)";
        else if (!companyCheckBox.isSelected()){
            if(comapnyChoiceBox.getSelectionModel().getSelectedItem() == null) return "No company selected!";
        }
        else if(companyCheckBox.isSelected()){
            if (companyIdField.getText().isEmpty()) return "Company ID field is empty!";
            else if (companyNameField.getText().isEmpty()) return "Company name field is empty!";
            else if (companyAdressField.getText().isEmpty()) return "Company adress field is empty!";
            else if (companyAccountNumberField.getText().isEmpty()) return "Company account number field is empty!";
            else if (!isInteger(companyAccountNumberField.getText().trim())) return "Invalid company account number!";
        }
        return "true";
    }

    private boolean isEmail(String email) {
        String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @FXML
    private void onNewCompanyChosen(){
        companyVBOX.setDisable(!companyCheckBox.isSelected());
    }

    private boolean isInteger(String value){
        if(value == null || value.isEmpty()) return false;
        try {
            Integer.parseInt(value);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
