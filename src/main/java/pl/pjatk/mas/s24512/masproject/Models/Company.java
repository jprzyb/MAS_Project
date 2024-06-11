package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String id;
    private String name;
    private String adress;
    private String accountNumber;
    private boolean isRegular;
    private List<String> subordinatesIds;

    public Company(String id, String name, String adress, String accountNumber, boolean isRegular, List<String> subordinatesIds) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.accountNumber = accountNumber;
        this.isRegular = isRegular;
        this.subordinatesIds = new ArrayList<>();
        this.subordinatesIds.addAll(subordinatesIds);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public void setRegular(boolean regular) {
        isRegular = regular;
    }

    public List<String> getSubordinatesIds() {
        return subordinatesIds;
    }

    public void setSubordinatesIds(List<String> subordinatesIds) {
        this.subordinatesIds = subordinatesIds;
    }

    public void addSubordinate(String subordinateId) {
        // client side setting company
        if(!Util.getClientById(subordinateId).getCompanyId().equals(this.id)) Util.getClientById(subordinateId).setCompanyId(this.id);
        // adding id to subordinates ids
        if(!subordinatesIds.contains(subordinateId)) this.subordinatesIds.add(subordinateId);
    }

    public void removeSubordinate(String subordinateId) {
        // removing from subordinates
        if(subordinatesIds.contains(subordinateId)) this.subordinatesIds.remove(subordinateId);
        Util.getClientById(subordinateId).setCompanyId("");
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
