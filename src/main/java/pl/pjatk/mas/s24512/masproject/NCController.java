package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.pjatk.mas.s24512.masproject.Models.Campaign;
import pl.pjatk.mas.s24512.masproject.Models.Client;
import pl.pjatk.mas.s24512.masproject.Models.Plan;
import pl.pjatk.mas.s24512.masproject.Models.enums.ChannelType;
import pl.pjatk.mas.s24512.masproject.Models.enums.SettlementType;
import pl.pjatk.mas.s24512.masproject.Models.enums.SizeType;
import pl.pjatk.mas.s24512.masproject.Models.enums.StatusType;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.ResourceBundle;
import java.util.UUID;

public class NCController implements Initializable {
    @FXML
    TextField idField;
    @FXML
    TextField nameField;
    @FXML
    DatePicker startDateDatePicker;
    @FXML
    DatePicker endDateDatePicker;
    @FXML
    ChoiceBox<SettlementType> methodOfSettlement;
    @FXML
    TextField estimationsField;
    @FXML
    CheckBox newCreationCheckBox;
    @FXML
    ChoiceBox<SizeType> sizeChoiceBox;
    @FXML
    CheckBox animatedCheckBox;
    @FXML
    ChoiceBox<ChannelType> communicationChannelChoiceBox;
    @FXML
    ChoiceBox<Client> clientChoiceBox;
    @FXML
    TextArea descriptionField;
    @FXML
    TextArea targetField;
    @FXML
    TextArea creationDescriptionField;
    @FXML
    Label infoLabel;
    @FXML
    Button newClientButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newCreationCheckBox.setSelected(false);
        animatedCheckBox.setSelected(false);

        idField.setText(String.valueOf(UUID.randomUUID()));

        methodOfSettlement.getItems().addAll(EnumSet.allOf(SettlementType.class));
        sizeChoiceBox.getItems().addAll(EnumSet.allOf(SizeType.class));
        communicationChannelChoiceBox.getItems().addAll(EnumSet.allOf(ChannelType.class));
        clientChoiceBox.getItems().addAll(Util.clients);
    }
    @FXML
    private void setCrationDescriptionFieldEdition(){
        creationDescriptionField.setDisable(!newCreationCheckBox.isSelected());
    }
    @FXML
    private void onCancelButtonClick(ActionEvent event){
        Stage  stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    private void onSaveButtonClick(ActionEvent event){
        String validationResult = validateInput();
        if(validationResult.equals("true")){
            Plan plan = new Plan(String.valueOf(UUID.randomUUID()), Integer.parseInt(estimationsField.getText()),
                    targetField.getText(), communicationChannelChoiceBox.getSelectionModel().getSelectedItem(), idField.getText());
            Campaign campaign = new Campaign(idField.getText(), nameField.getText(), new Date(startDateDatePicker.getValue().toEpochDay()),
                    new Date(endDateDatePicker.getValue().toEpochDay()), 0, newCreationCheckBox.isSelected(),
                    sizeChoiceBox.getSelectionModel().getSelectedItem(), animatedCheckBox.isSelected(),
                    (newCreationCheckBox.isSelected() ? creationDescriptionField.getText() : ""), StatusType.PLANNED,
                    methodOfSettlement.getSelectionModel().getSelectedItem(), plan.getId(), clientChoiceBox.getSelectionModel().getSelectedItem().getId(),
                    Util.LOGGED_ON_ID, "", "", "");

            Util.campaigns.add(campaign);
            Util.plans.add(plan);
            onCancelButtonClick(event);
        }else {
            infoLabel.setText(validationResult);
        }
    }

    @FXML
    private void onNewClientAction(){
        onNewClientSelected();
        showNewClient();
    }
    private void showNewClient(){
        NCliController.showNewClientWindow(this);
    }

    public static void showNewCampaign(CPController parent){
        try {
            FXMLLoader loader = new FXMLLoader(MIController.class.getResource("new-campaign-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("New Campaign");
            stage.show();
            stage.setOnHiding((WindowEvent event) -> parent.afterNewCampaignClose());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String validateInput(){
        if(nameField.getText() == null || nameField.getText().isEmpty()) return "Campaign name is empty.";
        else if(startDateDatePicker.getValue().isBefore(LocalDate.now())) return "Invalid start date.";
        else if(endDateDatePicker.getValue().isBefore(startDateDatePicker.getValue())) return "Invalid end date.";
        else if(methodOfSettlement.getValue() == null) return "Invalid method of settlement.";
        else if(!isInteger(estimationsField.getText())) return "Invalid estimations (should be integer).";
        else if(sizeChoiceBox.getValue() == null) return "Invalid creation size.";
        else if(communicationChannelChoiceBox.getValue() == null) return "Invalid communication channel.";
        else if(clientChoiceBox.getValue() == null) return "Invalid client.";
        else if(descriptionField.getText() == null || descriptionField.getText().isEmpty()) return "Description is required.";
        else if(targetField.getText() == null || targetField.getText().isEmpty()) return "Target description is required.";
        return "true";
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
    private void onNewClientSelected(){
        clientChoiceBox.setDisable(true);
        newClientButton.setDisable(true);
    }

    public void afterNewClientClose(){
        if(!clientChoiceBox.getItems().isEmpty()) clientChoiceBox.getItems().removeAll(clientChoiceBox.getItems());
        clientChoiceBox.getItems().addAll(Util.clients);
        clientChoiceBox.setDisable(false);
        newClientButton.setDisable(false);
    }
}
