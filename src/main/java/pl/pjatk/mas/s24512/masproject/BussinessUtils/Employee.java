package pl.pjatk.mas.s24512.masproject.BussinessUtils;

public class Employee {
    int id;
    String firstName;
    String lastName;
    String login;
    String password;
    public Employee(int id, String firstName, String lastName, String login, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
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
