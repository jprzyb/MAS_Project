package pl.pjatk.mas.s24512.masproject;

import pl.pjatk.mas.s24512.masproject.BussinessUtils.Employee;

public class Util {
    public static Employee loggedOn = new Employee(-1,"","", "","");

    public static void setEmployeeLoggedOn(Employee employee){
        loggedOn = employee;
    }

}
