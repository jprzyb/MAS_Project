package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pl.pjatk.mas.s24512.masproject.Models.Campaign;

import java.net.URL;
import java.util.ResourceBundle;

public class CPController implements Initializable {
    @FXML
    ListView<Campaign> campaignList;
    @FXML
    Button newCampaignButton;
    @FXML
    Button myInfoButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        campaignList.getItems().addAll(Util.getCampaignsByPlannerId(Util.LOGGED_ON_ID));
    }
    @FXML
    private void showNewCampaign(ActionEvent event){
        NCController.showNewCampaign(this);
        newCampaignButton.setDisable(true);
    }
    @FXML
    private void showMyInformation(ActionEvent event){
        MIController.showMyInformation(this);
        myInfoButton.setDisable(true);
    }
    @FXML
    private void logout(ActionEvent event){
        LoginController.setToLogOffScene(event);
    }

    private void loadLists(){
        if (campaignList != null){
            campaignList.getItems().removeAll(campaignList.getItems());
            campaignList.getItems().addAll(Util.getCampaignsByPlannerId(Util.LOGGED_ON_ID));
        }
    }

    public void afterNewCampaignClose(){
        loadLists();
        newCampaignButton.setDisable(false);
    }
    public void afterMyInfoClose(){
        myInfoButton.setDisable(false);
    }
}
