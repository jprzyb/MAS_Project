package pl.pjatk.mas.s24512.masproject.Repository;

import pl.pjatk.mas.s24512.masproject.DBUtils.Campaigns;

import java.util.Date;
import java.util.List;

public class CommunicationPlanner extends Employee{
    private List<Campaign> campaigns;
    public CommunicationPlanner(Employee employee, List<Campaign> campaigns) {
        super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getLogin(), employee.getPassword(), employee.getBirthDate(), employee.getEmploymentDate(), employee.getSalary(), employee.getManagerId(), employee.getLevelOfEducation());
        this.campaigns = campaigns;
    }

    /**
     * This method returns all campaigns assigned to Communication Planner
     * Mostly used to init GUI list
     * @return result
     */
    public List<Campaign> getCampaignsAssigned(){
        return campaigns;
    }

    public void setCampaignsAssigned(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }
}
