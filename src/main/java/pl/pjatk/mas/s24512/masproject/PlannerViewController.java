package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import pl.pjatk.mas.s24512.masproject.DBUtils.Campaigns;
import pl.pjatk.mas.s24512.masproject.Repository.Campaign;

import java.net.URL;
import java.util.ResourceBundle;

public class PlannerViewController implements Initializable {
    @FXML
    ListView<Campaign> campaignList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadList();
    }

    @FXML
    private void logout(ActionEvent event){
        LoginController.setToLogOffScene(event);
    }

    @FXML
    private void showMyInformation(){
        MyInformationController.showMyInformation();
    }
    @FXML
    private void showNewCampaign(){
        NewCampaignController.showNewCampaign(this);
    }
    public void loadList(){
        campaignList.getItems().removeAll(campaignList.getItems());
        campaignList.getItems().addAll(Campaigns.getCampaignsForPlannerWithId(Util.loggedOnEmployee.getId()));
    }
}
