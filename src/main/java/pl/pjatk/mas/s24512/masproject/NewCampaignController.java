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
import pl.pjatk.mas.s24512.masproject.DBUtils.Campaigns;
import pl.pjatk.mas.s24512.masproject.DBUtils.Clients;
import pl.pjatk.mas.s24512.masproject.Repository.*;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.UUID;

public class NewCampaignController implements Initializable {

    @FXML
    TextField idField;
    @FXML
    TextField nameField;
    @FXML
    DatePicker startDateDatePicker;
    @FXML
    DatePicker endDateDatePicker;
    @FXML
    ChoiceBox<Price> methodOfSettlement;
    @FXML
    TextField estimationsField;
    @FXML
    CheckBox newCreationCheckBox;
    @FXML
    ChoiceBox<CreationType> sizeChoiceBox;
    @FXML
    CheckBox animatedCheckBox;
    @FXML
    ChoiceBox<CommunicationChannels> communicationChannelChoiceBox;
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newCreationCheckBox.setSelected(false);
        animatedCheckBox.setSelected(false);

        idField.setText(String.valueOf(UUID.randomUUID()));
        Arrays.asList(Price.values()).forEach(c -> methodOfSettlement.getItems().add(c));
        for (CreationType c : CreationType.values()) sizeChoiceBox.getItems().add(c);
        Arrays.asList(CommunicationChannels.values()).forEach(c -> communicationChannelChoiceBox.getItems().add(c));
        Clients.getAllClients().forEach(c -> clientChoiceBox.getItems().add(c));

    }

    public static void showNewCampaign(PlannerViewController parent){
        try {
            FXMLLoader loader = new FXMLLoader(MyInformationController.class.getResource("new-campaign-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("New Campaign");
            stage.show();
            stage.setOnHiding((WindowEvent event) -> parent.loadList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setCrationDescriptionFieldEdition(){
        creationDescriptionField.setDisable(!newCreationCheckBox.isSelected());
    }
    @FXML
    private void onSaveButtonClick(ActionEvent event){
        String validationResult = validateInput();
        if(validationResult.equals("true")){
            Plan plan = new Plan(String.valueOf(UUID.randomUUID()), Integer.parseInt(estimationsField.getText()), targetField.getText(),communicationChannelChoiceBox.getValue());
            Campaign campaign = new Campaign(
                    idField.getText(), nameField.getText(), Date.valueOf(startDateDatePicker.getValue()), Date.valueOf(endDateDatePicker.getValue()), 0,
                    newCreationCheckBox.isSelected(), sizeChoiceBox.getValue(), animatedCheckBox.isSelected(), creationDescriptionField.getText(), CampaignStatus.PLANNED,
                    Util.loggedOnEmployee.getId(),"",clientChoiceBox.getValue().getId(), plan.getId(),""
            );
            infoLabel.setText("Saving");
            boolean campaignFlag =  Campaigns.addCampaignToDB(campaign);
            boolean planFlag = Campaigns.addPlanToDB(plan);
            if(campaignFlag && planFlag){
                onCancelButtonClick(event);
            }else {
                infoLabel.setText("Something went wrong while saving!");
            }
        }else {
            infoLabel.setText(validationResult);
        }
    }
    @FXML
    private void onCancelButtonClick(ActionEvent event){
        Stage  stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
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
}
