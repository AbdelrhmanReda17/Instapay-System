package Providers.AccountProviders.Wallets;

import Providers.AccountProviders.WalletProvider;
import User.Account;

public class FawryProvider extends WalletProvider {
    private final String Name = "Fawry";
    @Override
    public Account UpdateHandler() {
        return null;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public Account getAccount(String PhoneNumber) {
        return null;
    }
}