package pl.pjatk.mas.s24512.masproject.Repository;

import pl.pjatk.mas.s24512.masproject.DBUtils.Companies;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private String emailAdress;
    private String phoneNumber;
    private String companyId;

    public Client(String id, String firstName, String lastName, String emailAdress, String phoneNumber, String companyId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
        this.companyId = companyId;
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

    public String getEmailAdress() {
        return emailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompanyId() {
        return companyId;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + "("+ Companies.getCompanyById(companyId) +")";
    }
}
