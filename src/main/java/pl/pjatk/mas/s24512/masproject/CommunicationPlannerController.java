package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pl.pjatk.mas.s24512.masproject.DBUtils.Campaigns;
import pl.pjatk.mas.s24512.masproject.DBUtils.Employees;
import pl.pjatk.mas.s24512.masproject.Repository.Campaign;
import pl.pjatk.mas.s24512.masproject.Repository.CommunicationPlanner;

import java.net.URL;
import java.util.ResourceBundle;

public class CommunicationPlannerController implements Initializable {
    @FXML
    ListView<Campaign> campaignList;
    @FXML
    Button newCampaignButton;
    @FXML
    Button myInfoButton;
    @FXML
    CommunicationPlanner communicationPlanner;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        communicationPlanner = new CommunicationPlanner(Util.loggedOnEmployee, Campaigns.getCampaignsForPlannerWithId(Util.loggedOnEmployee.getId()));
        loadLists();
    }

    @FXML
    private void logout(ActionEvent event){
        LoginController.setToLogOffScene(event);
    }

    @FXML
    private void showMyInformation(){
        myInfoButton.setDisable(true);
        MyInformationController.showMyInformation(this);
    }
    @FXML
    private void showNewCampaign(){
        newCampaignButton.setDisable(true);
        NewCampaignController.showNewCampaign(this);
    }
    private void loadLists(){
        if (campaignList != null){
            communicationPlanner.setCampaignsAssigned(Campaigns.getCampaignsForPlannerWithId(communicationPlanner.getId()));
            campaignList.getItems().removeAll(campaignList.getItems());
            campaignList.getItems().addAll(communicationPlanner.getCampaignsAssigned());
        }
    }
    public void afterNewCampaignClose(){
        loadLists();
        newCampaignButton.setDisable(false);
    }
    public void afterMyInfoClose(){
        Util.setLoggedOnEmployee(Employees.getEmployeeById(Util.loggedOnEmployee.getId()));
        myInfoButton.setDisable(false);
    }
}
