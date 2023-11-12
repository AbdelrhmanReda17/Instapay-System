package Providers;

import User.Account;

public abstract class BankProvider implements IProvider {

    @Override
    public boolean Verify(String BankType , String AccountId) {
        Account account = getAccount(AccountId);
        return account != null;
    }
    @Override
    public void Update() {

    }

    abstract public Account getAccount(String AccountId);
    abstract public Account UpdateHandler();
}
