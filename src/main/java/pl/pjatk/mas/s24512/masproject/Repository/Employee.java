package pl.pjatk.mas.s24512.masproject.Repository;

import pl.pjatk.mas.s24512.masproject.DBUtils.Employees;
import pl.pjatk.mas.s24512.masproject.DBUtils.EmployeesTypes;
import pl.pjatk.mas.s24512.masproject.Util;

import java.util.Date;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Date birthDate;
    private Date employmentDate;
    private double salary;
    private String managerId;
    private LevelOfEducation levelOfEducation;
    public Employee(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, String managerId, LevelOfEducation levelOfEducation){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.salary = salary;
        this.managerId = managerId;
        this.levelOfEducation = levelOfEducation;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public double getSalary() {
        return salary;
    }

    public String getManagerId() {
        return managerId;
    }
    public LevelOfEducation getLevelOfEducation() {
        return levelOfEducation;
    }

    public String getRole(){
        if(EmployeesTypes.IsCommunicationPlanner(getId())) return "Communication Planner";
        else if(EmployeesTypes.IsPlannerManager (getId())) return "Planner Manager";
        else if(EmployeesTypes.IsTraffic (getId())) return "Traffic";
        else if(EmployeesTypes.IsTrafficManager (getId())) return "Traffic Manager";
        else if(EmployeesTypes.IsTrafficAIO (getId())) return "Traffic / Traffic Manager";
        else if(EmployeesTypes.IsDesigner (getId())) return "Designer";
        else if(EmployeesTypes.IsCampaignAccountant (getId())) return "Campaign accountant";
        else if(EmployeesTypes.IsCorporateAccountant (getId())) return "Company accountant";
        else if(EmployeesTypes.IsAccountantAIO (getId())) return "Company/Campaign Accountant";

        return "";
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
