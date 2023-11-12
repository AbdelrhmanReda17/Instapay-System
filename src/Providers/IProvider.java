package Providers;

import User.Account;

public interface IProvider {
    public boolean Verify(String ProviderType , String AccountId);
    public void Update();
    public Account getAccount(String token);
}