package Providers.AccountProviders;

import User.Account;

public interface IProvider {
    public  int Verify(String data);

    public String getName();
    public Account getAccount(String token);

    public Account Deposit(Account account, double ammount);
    public Account Withdraw(Account account, double ammount);
}