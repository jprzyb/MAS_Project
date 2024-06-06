package pl.pjatk.mas.s24512.masproject.Repository;

import pl.pjatk.mas.s24512.masproject.DBUtils.Employees;
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
        if(Employees.IsCommunicationPlanner(getId())) return "Communication Planner";
        else if(Employees.IsPlannerManager (getId())) return "Traffic";
        else if(Employees.IsTraffic (getId())) return "Communication Manager";
        else if(Employees.IsTrafficManager (getId())) return "Traffic Manager";
        else if(Employees.IsTrafficAIO (getId())) return "Traffic / Traffic Manager";
        else if(Employees.IsDesigner (getId())) return "Designer";
        else if(Employees.IsCampaignAccountant (getId())) return "Campaign accountant";
        else if(Employees.IsCorporateAccountant (getId())) return "Company accountant";
        else if(Employees.IsAccountantAIO (getId())) return "Company/Campaign Accountant";

        return "";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", employmentDate=" + employmentDate +
                ", salary=" + salary +
                ", managerId='" + managerId + '\'' +
                '}';
    }
}
