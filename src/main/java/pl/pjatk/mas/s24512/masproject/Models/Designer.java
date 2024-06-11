package pl.pjatk.mas.s24512.masproject.Models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Designer extends Employee{

    List<String> campaignsId;
    public Designer(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> campaignsId) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        campaignsId = new ArrayList<>();
        campaignsId.addAll(campaignsId);
    }
}
