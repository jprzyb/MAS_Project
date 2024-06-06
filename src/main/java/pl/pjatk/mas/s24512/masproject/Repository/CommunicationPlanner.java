package pl.pjatk.mas.s24512.masproject.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunicationPlanner extends Employee{
    private List<Campaign> campaignsAssigned;
    public CommunicationPlanner(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, LevelOfEducation levelOfEducation) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, null, levelOfEducation);
    }

    /**
     * This method returns all campaigns assigned to Communication Planner
     * Mostly used to init GUI list
     * @return result
     */
    public List<Campaign> getCampaignsAssigned(){
        List<Campaign> result = new ArrayList<>();

        return result;
    }
}
