package Entities.User;

import Providers.AccountProviders.IProvider;

public class BankAccount extends Account {
    public BankAccount(String AccountID, double Amount , String phoneNumber ){
        super( AccountID,Amount , phoneNumber);
    }

    public String getData() {
        return  getAccountId();
    }
    public String getType() {
        return  "Bank";
    }
}