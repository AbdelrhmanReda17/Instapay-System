package Entities.User;

import Providers.AccountProviders.IProvider;

public class BankAccount extends Account {
    public BankAccount() {
        super(null,0 , null , "0");
    }
    public BankAccount(String AccountID, double Amount , IProvider bankProvider , String phoneNumber ){
        super( AccountID,Amount , bankProvider , phoneNumber);
    }

    public String getData() {
        return  "Bank" + "-" + getProvider().getName() + "," + getAccountId();
    }
}