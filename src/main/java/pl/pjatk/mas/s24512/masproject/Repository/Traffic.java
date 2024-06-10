package pl.pjatk.mas.s24512.masproject.Repository;

import java.util.List;

public class Traffic extends Employee{
    private List<Campaign> campaigns;

    public Traffic(Employee employee, List<Campaign> campaigns) {
        super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getLogin(), employee.getPassword(), employee.getBirthDate(), employee.getEmploymentDate(), employee.getSalary(), employee.getManagerId(), employee.getLevelOfEducation());
        this.campaigns.addAll(campaigns);
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }
}
