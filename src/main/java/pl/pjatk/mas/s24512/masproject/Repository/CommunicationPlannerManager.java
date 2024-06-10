package pl.pjatk.mas.s24512.masproject.Repository;

import pl.pjatk.mas.s24512.masproject.DBUtils.AnnualBonuses;

import java.util.List;

public class CommunicationPlannerManager extends CommunicationPlanner{
    private List<Employee> employeeList;
    private static double annualBonus;

    public CommunicationPlannerManager(Employee employee, List<Campaign> campaigns, List<Employee> employeeList) {
        super(employee, campaigns);
        this.employeeList = employeeList;
        setAnnualBonus(AnnualBonuses.getAnnualBonusForPlanners());
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static double getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(double bonus){
        annualBonus = bonus;
    }
    public void setEmployeeList(List<Employee> employeeList){
        this.employeeList = employeeList;
    }
}
