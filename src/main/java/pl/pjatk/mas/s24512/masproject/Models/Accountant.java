package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.AccountantType;

import java.sql.Date;
import java.util.EnumSet;
import java.util.List;

public class Accountant extends Employee{
    public static List<String> invoices;
    public List<String> invoicesMade;
    public List<String> monthlyPayment;
    private EnumSet<AccountantType> type;
    public Accountant(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, EnumSet<AccountantType> type) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        this.type = type;
    }
    public void calcInvoice(String campaignId){
        if(!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return;
    }
    public double calcCorpIncome(Date start, Date stop){

        return 0.0;
    }

    public List<String> getInvoices() {
        if(!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return null;

        return invoices;
    }

    public void setInvoices(List<String> invoices) {
        if(!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return;
        Accountant.invoices = invoices;
    }

    public List<String> getInvoicesMade() {
        if(!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return null;
        return invoicesMade;
    }

    public void setInvoicesMade(List<String> invoicesMade) {
        if(!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return;
        this.invoicesMade = invoicesMade;
    }
    public void addInvoice(String invoice){
        if(!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return;
        if(!invoices.contains(invoice)) invoices.add(invoice);
    }

    public List<String> getMonthlyPayment() {
        if(!type.contains(AccountantType.ACCOUNTANT_COMPANY)) return null;
        return monthlyPayment;
    }

    public void setMonthlyPayment(List<String> monthlyPayment) {
        if(!type.contains(AccountantType.ACCOUNTANT_COMPANY)) return;
        this.monthlyPayment = monthlyPayment;
    }

    public EnumSet<AccountantType> getType() {
        return type;
    }
    public void addType(AccountantType type) {
        if(!this.type.contains(type)) this.type.add(type);
    }
    public void removeType(AccountantType type) {
        if(this.type.contains(type)) this.type.remove(type);
    }

    public void setType(EnumSet<AccountantType> type) {
        this.type = type;
    }
}
