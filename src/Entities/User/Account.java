package Entities.User;

import Providers.AccountProviders.IProvider;

public abstract class Account {
    private double amount;
    private final String phoneNumber;
    private final String accountId;
    private final String password;
    public Account(String accountId, String password  ,double amount , String phoneNumber) {
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        this.accountId = accountId;
        this.password = password;
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public double getAmount() {
        return amount;
    }
    public String getPassword() {
        return password;
    }

    abstract public String getData();
    abstract public String getType();

}
