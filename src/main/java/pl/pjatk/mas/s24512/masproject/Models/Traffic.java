package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Traffic extends Employee implements ITraffic {

    private List<String> campaignIds;
    private String managerId;

    public Traffic(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> campaignIds, String managerId) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        this.campaignIds = new ArrayList<>();
        this.campaignIds.addAll(campaignIds);
        this.managerId = managerId;
    }

    @Override
    public void editCampaign(String campaignId) {

    }

    public List<String> getIdsOfCampaigns() {
        return campaignIds;
    }

    public void setIdsOfCampaigns(List<String> idsOfCampaigns) {
        this.campaignIds = idsOfCampaigns;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        // removing from old manager
        if(Util.getTrafficManagerById(this.managerId).getSubordinatesIds().contains(this.getId()))  {
            Util.getTrafficManagerById(this.managerId).removeSubordinate(this.getId());
        }
        this.managerId = managerId;
        // adding to new manager
        if(Util.getTrafficManagerById(this.managerId).getSubordinatesIds().contains(this.getId()))  {
            Util.getTrafficManagerById(this.managerId).addSubordinate(this.getId());
        }
    }
}
