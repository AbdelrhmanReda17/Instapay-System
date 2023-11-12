package Providers.AccountProviders;

import User.Account;

public abstract class WalletProvider implements IProvider {

    @Override
    public int Verify(String phone ){
        return 0;
    }

    @Override
    public void Update() {

    }

    abstract public Account getAccount(String AccountId);
    abstract public Account UpdateHandler();
}
