package Providers.AccountProviders;

import User.Account;

public abstract class WalletProvider implements IProvider {

    @Override
    public boolean Verify(String WalletType , String AccountId) {
        return true;
    }

    @Override
    public void Update() {

    }

    abstract public Account getAccount(String AccountId);
    abstract public Account UpdateHandler();
}
