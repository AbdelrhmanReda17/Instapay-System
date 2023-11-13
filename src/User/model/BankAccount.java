package User.model;

import Providers.AccountProviders.IProvider;
import User.model.Account;

public class BankAccount extends Account {
    private String AccountID;
    public BankAccount() {
        super(0 , null , "0");
    }
    public BankAccount(String AccountID, double Amount , IProvider bankProvider , String phoneNumber ){
        super(Amount , bankProvider , phoneNumber);
        this.AccountID = AccountID;
    }
    public String getAccountID() {
        return AccountID;
    }
    public void Display() {
        System.out.println("Account ID: " + this.AccountID);
        System.out.println("Amount: " + getAmount());
    }
    public String getData() {
        return  "Bank" + "-" + getProvider().getName() + "," + AccountID;
    }
}