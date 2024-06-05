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

    /**
     * Method that returns employee id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Method that returns employee first name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method that returns employee last name
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method that returns employee login
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Method that returns employee password
     * @return password
     */
    public String getPassword() {
        return password;
    }
}
