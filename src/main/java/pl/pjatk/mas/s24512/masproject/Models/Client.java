package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String companyId;

    public Client(String id, String firstName, String lastName, String email, String phoneNumber, String companyId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.companyId = companyId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        // removing from old
        if(Util.getCompanyById(this.companyId).getSubordinatesIds().contains(this.id)) Util.getCompanyById(companyId).removeSubordinate(this.id);
        // adding to new
        if(!Util.getCompanyById(companyId).getSubordinatesIds().contains(this.id)) Util.getCompanyById(companyId).addSubordinate(this.id);
        // set
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return firstName + lastName;
    }
}
