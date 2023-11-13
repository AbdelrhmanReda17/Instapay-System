package Providers.AccountProviders;

import User.Account;

public abstract class WalletProvider implements IProvider {

    @Override
    public int Verify(String phone ){
        return 0;
    }
}
