package Entities.User;

import Providers.AccountProviders.IProvider;

public abstract class Account {
    private double amount;
    private final IProvider provider;
    private final String phoneNumber;
    private final String accountId;
    public Account(String accountId ,double amount , IProvider provider , String phoneNumber) {
        this.amount = amount;
        this.provider = provider;
        this.phoneNumber = phoneNumber;
        this.accountId = accountId;
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
    public IProvider getProvider() {
        return provider;
    }
    public double getAmount() {
        return amount;
    }
    abstract public String getData();
}
