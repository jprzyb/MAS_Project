package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pjatk.mas.s24512.masproject.Models.Campaign;
import pl.pjatk.mas.s24512.masproject.Models.Plan;
import pl.pjatk.mas.s24512.masproject.Models.Price;
import pl.pjatk.mas.s24512.masproject.Models.enums.SettlementType;

import java.net.URL;
import java.util.ResourceBundle;

public class CIController implements Initializable {

    private static  Campaign campaign;

    @FXML
    TextField idField;
    @FXML
    TextField nameField;
    @FXML
    TextField startDateDatePicker;
    @FXML
    TextField endDateDatePicker;
    @FXML
    TextField methodOfSettlement;
    @FXML
    TextField estimationsField;
    @FXML
    TextField newCreationField;
    @FXML
    TextField sizeField;
    @FXML
    TextField isAnimatedField;
    @FXML
    TextField communicationChannelField;
    @FXML
    TextField clientField;
    @FXML
    TextField priceField;
    @FXML
    TextArea descriptionField;
    @FXML
    TextArea targetField;
    @FXML
    TextArea creationDescriptionField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Plan plan = Util.getPlanById(campaign.getPlanId());
        double price;
        if(campaign.getSettlement().equals(SettlementType.CPM)) price = plan.getEstimatedRate() * Price.getPriceForSettlement(campaign.getSettlement()) / 1000;
        else price = plan.getEstimatedRate() * Price.getPriceForSettlement(campaign.getSettlement());

        idField.setText(campaign.getId());
        nameField.setText(campaign.getName());
        startDateDatePicker.setText(String.valueOf(campaign.getStartDate()));
        endDateDatePicker.setText(String.valueOf(campaign.getEndDate()));
        methodOfSettlement.setText(String.valueOf(campaign.getSettlement()));
        estimationsField.setText(campaign.getCurrentRate() + " / " + plan.getEstimatedRate());
        newCreationField.setText(String.valueOf(campaign.isNeedsNewCreation()));
        sizeField.setText(String.valueOf(campaign.getSize()));
        isAnimatedField.setText(String.valueOf(campaign.isAnimated()));
        communicationChannelField.setText(String.valueOf(plan.getCommunicationChannel()));
        clientField.setText(Util.getClientById(campaign.getClientId()).toString());
        priceField.setText(String.valueOf(price));
        descriptionField.setText(campaign.getDescription());
        creationDescriptionField.setText(campaign.getCreationDesc());
        targetField.setText(plan.getTarget());
    }

    @FXML
    private void onOkButtonClick(ActionEvent event){
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public static void showCampaignDetailsWindow(Campaign c){
        campaign = c;
        try {
            FXMLLoader loader = new FXMLLoader(ESController.class.getResource("campaign-details-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Campaign Details");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
