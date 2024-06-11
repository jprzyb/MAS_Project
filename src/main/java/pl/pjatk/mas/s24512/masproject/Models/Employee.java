package pl.pjatk.mas.s24512.masproject.Models;

import java.sql.Date;
import java.time.LocalDate;

public abstract class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Date birthDate;
    private Date employmentDate;
    private double salary;
    private EducationLevel educationLevel;

    public Employee(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.salary = salary;
        this.educationLevel = educationLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getSalary() {
        return salary;
    }
    public double getFinalSalary(){
        return salary*educationLevel.getFactor();
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public int calcAge(){
        return birthDate.getYear() - LocalDate.now().getYear();
    }
    public int calcSeniority(){
        return employmentDate.getYear() - LocalDate.now().getYear();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
