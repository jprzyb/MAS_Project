package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CommunicationPlannerManager extends Employee{
    private static double ANNUAL_BONUS;
    private List<String> campaignsIds;
    private List<String> subordinatesIds;
    public CommunicationPlannerManager(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> campaignsIds, List<String> subordinatesIds) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        this.campaignsIds = new ArrayList<>();
        this.campaignsIds.addAll(campaignsIds);
        this.subordinatesIds = new ArrayList<>();
        this.subordinatesIds.addAll(subordinatesIds);
    }

    public CommunicationPlannerManager(CommunicationPlanner cp, List<String> subordinatesIds) {
        super(cp.getId(), cp.getFirstName(), cp.getLastName(), cp.getLogin(), cp.getPassword(), cp.getBirthDate(), cp.getEmploymentDate(), cp.getSalary(), cp.getEducationLevel());
        this.campaignsIds = new ArrayList<>();
        this.campaignsIds.addAll(cp.getCampaignsIds());
        this.subordinatesIds = new ArrayList<>();
        this.subordinatesIds.addAll(subordinatesIds);
    }

    public static void setAnnualBonus(double annualBonus){
        ANNUAL_BONUS = annualBonus;
    }

    public static double getAnnualBonus() {
        return ANNUAL_BONUS;
    }

    public List<String> getCampaignsIds() {
        return campaignsIds;
    }

    public void setCampaignsIds(List<String> campaignsIds) {
        this.campaignsIds = campaignsIds;
    }

    public List<String> getSubordinatesIds() {
        return subordinatesIds;
    }

    public void setSubordinatesIds(List<String> subordinatesIds) {
        this.subordinatesIds = subordinatesIds;
    }
    public void removeSubordinate(String subordinateId){
        subordinatesIds.remove(subordinateId);
        Util.getCommunicationPlannerById(subordinateId).setManagerId("");
    }
    public void addSubordinate(String subordinateId){
        if(!subordinatesIds.contains(subordinateId)) {
            subordinatesIds.add(subordinateId);
            if (!Util.getCommunicationPlannerById(subordinateId).getManagerId().equals(this.getId()))
                Util.getCommunicationPlannerById(subordinateId).setManagerId(this.getId());
        }
    }

    public void setSubordinateSalary(String subordinateId, double salary){
        Util.getCommunicationPlannerById(subordinateId).setSalary(salary);
    }
}
