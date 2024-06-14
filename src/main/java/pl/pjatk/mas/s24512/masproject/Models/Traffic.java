package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Traffic employee who manages campaigns.
 * Extends the Employee class and implements the ITraffic interface.
 */
public class Traffic extends Employee implements ITraffic {

    private List<String> campaignIds; // List of campaign IDs managed by this Traffic employee
    private String managerId; // ID of the Traffic manager for this employee

    /**
     * Constructs a Traffic object with specified attributes.
     *
     * @param id             The ID of the Traffic employee
     * @param firstName      The first name of the Traffic employee
     * @param lastName       The last name of the Traffic employee
     * @param login          The login username of the Traffic employee
     * @param password       The login password of the Traffic employee
     * @param birthDate      The birth date of the Traffic employee
     * @param employmentDate The date of employment of the Traffic employee
     * @param salary         The salary of the Traffic employee
     * @param educationLevel The education level of the Traffic employee
     * @param campaignIds    The list of campaign IDs managed by the Traffic employee
     * @param managerId      The ID of the Traffic manager for this employee
     */
    public Traffic(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> campaignIds, String managerId) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        this.campaignIds = new ArrayList<>();
        this.campaignIds.addAll(campaignIds);
        this.managerId = managerId;
    }

    /**
     * Placeholder method for editing a campaign.
     *
     * @param campaignId The ID of the campaign to edit
     */
    @Override
    public void editCampaign(String campaignId) {
        // Method not implemented
        // No implementation because it's not currently in use
    }

    /**
     * Retrieves the list of campaign IDs managed by this Traffic employee.
     *
     * @return The list of campaign IDs
     */
    public List<String> getIdsOfCampaigns() {
        return campaignIds;
    }

    /**
     * Sets the list of campaign IDs managed by this Traffic employee.
     *
     * @param idsOfCampaigns The list of campaign IDs to set
     */
    public void setIdsOfCampaigns(List<String> idsOfCampaigns) {
        this.campaignIds = idsOfCampaigns;
    }

    /**
     * Retrieves the ID of the Traffic manager for this employee.
     *
     * @return The ID of the Traffic manager
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * Sets the ID of the Traffic manager for this employee.
     * Transfers the employee from the old manager to the new manager.
     *
     * @param managerId The ID of the new Traffic manager
     */
    public void setManagerId(String managerId) {
        // Removing from old manager's list of subordinates
        if (Util.getTrafficManagerById(this.managerId).getSubordinatesIds().contains(this.getId())) {
            Util.getTrafficManagerById(this.managerId).removeSubordinate(this.getId());
        }
        this.managerId = managerId;
        // Adding to new manager's list of subordinates
        if (Util.getTrafficManagerById(this.managerId).getSubordinatesIds().contains(this.getId())) {
            Util.getTrafficManagerById(this.managerId).addSubordinate(this.getId());
        }
    }
}
