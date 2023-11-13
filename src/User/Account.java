package User;

import Providers.AccountProviders.IProvider;

public abstract class Account {
    private double amount;
    private final IProvider provider;
    private final String phoneNumber;
    
    public Account(double amount , IProvider provider , String phoneNumber) {
        this.amount = amount;
        this.provider = provider;
        this.phoneNumber = phoneNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void Deposit(double amount) {
        this.amount += amount;
    }
    public boolean Withdraw(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return true;
        }
        else {
            return false;
        }
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
