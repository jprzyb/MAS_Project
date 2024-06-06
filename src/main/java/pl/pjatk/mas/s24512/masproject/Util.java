package pl.pjatk.mas.s24512.masproject;

import pl.pjatk.mas.s24512.masproject.Repository.Employee;

public class Util {
    public static Employee loggedOnEmployee;

    public static void setLoggedOnEmployee(Employee employee){
        loggedOnEmployee = employee;
    }
}
