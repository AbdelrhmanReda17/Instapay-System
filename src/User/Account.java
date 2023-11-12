package User;

import Controllers.TransferController;
import Providers.IProvider;

public abstract class Account {
    private double amount;
    public Account(double amount) {
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
    public double getAmount() {
        return amount;
    }
    abstract public String getData();
}
