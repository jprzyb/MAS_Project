package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TrafficManager extends Employee{
    private static double ANNUAL_BONUS;
    private List<String> subordinatesIds;
    public TrafficManager(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> subordinatesIds) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        this.subordinatesIds = new ArrayList<>();
        this.subordinatesIds.addAll(subordinatesIds);
    }

    public static double getAnnualBonus() {
        return ANNUAL_BONUS;
    }

    public static void setAnnualBonus(double annualBonus) {
        ANNUAL_BONUS = annualBonus;
    }

    public List<String> getSubordinatesIds() {
        return subordinatesIds;
    }

    public void setSubordinatesIds(List<String> subordinatesIds) {
        this.subordinatesIds = subordinatesIds;
    }
    public void addSubordinate(String subordinateId){
        if(!subordinatesIds.contains(subordinateId)) {
            subordinatesIds.add(subordinateId);
            if (!Util.getTrafficById(subordinateId).getManagerId().equals(this.getId()))
                Util.getTrafficById(subordinateId).setManagerId(this.getId());
        }
    }
    public void removeSubordinate(String subordinateId){
        subordinatesIds.remove(subordinateId);
        Util.getTrafficById(subordinateId).setManagerId("");
    }
    public void setSubordinateSalary(String subordinateId, double salary){
        Util.getTrafficById(subordinateId).setSalary(salary);
    }
}
