package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CommunicationPlanner extends Employee{
    private List<String> campaignsIds;
    private String managerId;
    public CommunicationPlanner(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> campaignsIds, String managerId) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        this.campaignsIds = new ArrayList<>();
        this.campaignsIds.addAll(campaignsIds);
        this.managerId = managerId;
    }

    public CommunicationPlanner(CommunicationPlannerManager cpm, List<String> campaignsIds, String managerId) {
        super(cpm.getId(), cpm.getFirstName(), cpm.getLastName(), cpm.getLogin(), cpm.getPassword(), cpm.getBirthDate(), cpm.getEmploymentDate(), cpm.getSalary(), cpm.getEducationLevel());
        this.campaignsIds = new ArrayList<>();
        this.campaignsIds.addAll(campaignsIds);
        this.managerId = managerId;
    }

    public void addCampaign(String campaignId){
        campaignsIds.add(campaignId);
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        Util.getCommunicationPlannerManagerById(this.managerId).removeSubordinate(this.getId());
        this.managerId = managerId;
        Util.getCommunicationPlannerManagerById(managerId).addSubordinate(this.getId());
    }

    public List<String> getCampaignsIds() {
        return campaignsIds;
    }

    public void setCampaignsIds(List<String> idsOfCampaigns) {
        this.campaignsIds = idsOfCampaigns;
    }
}
