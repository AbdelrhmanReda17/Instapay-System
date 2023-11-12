package Providers.AccountProviders;

import User.Account;

public interface IProvider {
    public int Verify(String data);
    public void Update();
    public Account getAccount(String token);
}