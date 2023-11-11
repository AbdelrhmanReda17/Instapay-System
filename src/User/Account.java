package User;

import Controllers.TransferController;
import Providers.IProvider;

public abstract class Account {
//    private IProvider provider;
//    private TransferController transactionProcessor;
    private double Amount;

    public void Deposit(double amount) {
        this.Amount += amount;
    }
    public boolean Withdraw(double amount) {
        if (this.Amount >= amount) {
            this.Amount -= amount;
            return true;
        }
        else {
            return false;
        }
    }

//    public boolean Transfer(Account distAccount, double ammount) {
//        if (transactionProcessor.Transfer(this, distAccount, ammount)) {
//            provider.Verify();
//            return true;
//        } else {
//            return false;
//        }
//    }
}
