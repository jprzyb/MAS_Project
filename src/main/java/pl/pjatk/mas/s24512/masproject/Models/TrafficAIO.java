package pl.pjatk.mas.s24512.masproject.Models;

import java.sql.Date;
import java.util.List;

public class TrafficAIO extends TrafficManager implements ITraffic {

    private List<String> campaignIds;
    public TrafficAIO(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> subordinatesIds) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel, subordinatesIds);
    }

    public List<String> getCampaignIds() {
        return campaignIds;
    }

    public void setCampaignIds(List<String> campaignIds) {
        this.campaignIds = campaignIds;
    }

    public void addCamaignId(String campaignId){
        if(!campaignIds.contains(campaignId)) campaignIds.add(campaignId);
    }

    @Override
    public void editCampaign(String campaignId) {

    }
}
