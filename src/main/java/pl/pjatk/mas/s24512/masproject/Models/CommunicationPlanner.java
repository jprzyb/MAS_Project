package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * The CommunicationPlanner class represents an employee who plans communication campaigns.
 * It extends the Employee class and adds specific attributes and methods for managing campaigns.
 */
public class CommunicationPlanner extends Employee {
    private List<String> campaignsIds; // List of campaign IDs managed by the planner
    private String managerId; // ID of the manager overseeing the planner

    /**
     * Constructor for the CommunicationPlanner class.
     *
     * @param id               Unique identifier for the planner
     * @param firstName        First name of the planner
     * @param lastName         Last name of the planner
     * @param login            Login username of the planner
     * @param password         Password of the planner
     * @param birthDate        Birth date of the planner
     * @param employmentDate   Employment date of the planner
     * @param salary           Salary of the planner
     * @param educationLevel   Education level of the planner
     * @param campaignsIds     List of campaign IDs managed by the planner
     * @param managerId        ID of the manager overseeing the planner
     */
    public CommunicationPlanner(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> campaignsIds, String managerId) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        this.campaignsIds = new ArrayList<>();
        this.campaignsIds.addAll(campaignsIds);
        this.managerId = managerId;
    }

    /**
     * Constructor for the CommunicationPlanner class using a CommunicationPlannerManager object.
     *
     * @param cpm              CommunicationPlannerManager object
     * @param campaignsIds     List of campaign IDs managed by the planner
     * @param managerId        ID of the manager overseeing the planner
     */
    public CommunicationPlanner(CommunicationPlannerManager cpm, List<String> campaignsIds, String managerId) {
        super(cpm.getId(), cpm.getFirstName(), cpm.getLastName(), cpm.getLogin(), cpm.getPassword(), cpm.getBirthDate(), cpm.getEmploymentDate(), cpm.getSalary(), cpm.getEducationLevel());
        this.campaignsIds = new ArrayList<>();
        this.campaignsIds.addAll(campaignsIds);
        this.managerId = managerId;
    }

    /**
     * Adds a campaign ID to the list of campaigns managed by the planner.
     *
     * @param campaignId ID of the campaign to add
     */
    public void addCampaign(String campaignId) {
        campaignsIds.add(campaignId);
    }

    /**
     * Gets the manager ID overseeing the planner.
     *
     * @return Manager ID
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * Sets the manager ID overseeing the planner.
     * Updates the subordinates of the old and new manager accordingly.
     *
     * @param managerId New manager ID
     */
    public void setManagerId(String managerId) {
        // Remove from the old manager
        if ((managerId != null || !managerId.isEmpty()) && Util.getCommunicationPlannerManagerById(this.managerId) != null) {
            Util.getCommunicationPlannerManagerById(this.managerId).removeSubordinate(this.getId());
        }
        this.managerId = managerId;
        // Add to the new manager
        if (Util.getCommunicationPlannerManagerById(managerId) != null) {
            Util.getCommunicationPlannerManagerById(managerId).addSubordinate(this.getId());
        }
    }

    /**
     * Gets the list of campaign IDs managed by the planner.
     *
     * @return List of campaign IDs
     */
    public List<String> getCampaignsIds() {
        return campaignsIds;
    }

    /**
     * Sets the list of campaign IDs managed by the planner.
     *
     * @param idsOfCampaigns List of campaign IDs
     */
    public void setCampaignsIds(List<String> idsOfCampaigns) {
        this.campaignsIds = idsOfCampaigns;
    }
}
