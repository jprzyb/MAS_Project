package pl.pjatk.mas.s24512.masproject.Repository;

import java.util.Date;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Date birthDate;
    private Date employmentDate;
    private double salary;
    public Employee(int id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.salary = salary;
    }

    public int getId() {
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
}
