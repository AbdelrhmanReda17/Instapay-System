package Providers.AccountProviders;

import User.model.Account;

public abstract class IProvider {
    public abstract int Verify(String data);

    public abstract String getName();
    public abstract Account getAccount(String token);

    public boolean Transfer(Account srcAccount, Account destAccount, double amount) {
        if (Withdraw(srcAccount, amount)) {
            Deposit(destAccount, amount);
            return true;
        }
        else {
            return false;
        }
    }

    public abstract void Deposit(Account account, double ammount);
    public abstract boolean Withdraw(Account account, double ammount);
}