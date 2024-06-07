package pl.pjatk.mas.s24512.masproject.Repository;

public class Company {
    private String id;
    private String name;
    private String address;
    private String accountNumber;
    private boolean isRegular;

    public Company(String id, String name, String address, String accountNumber, boolean isRegular) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.accountNumber = accountNumber;
        this.isRegular = isRegular;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean getIsRegular() {
        return isRegular;
    }
    @Override
    public String toString(){
        return name;
    }
}
