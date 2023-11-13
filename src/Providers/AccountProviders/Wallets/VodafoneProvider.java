package Providers.AccountProviders.Wallets;

import Providers.AccountProviders.WalletProvider;
import User.Account;

public class VodafoneProvider extends WalletProvider {
    private final String Name = "Vodafone";
    @Override
    public Account getAccount(String AccountId) {
        return null;
    }
    @Override
    public String getName() {
        return Name;
    }
    @Override
    public Account UpdateHandler() {
        return null;
    }
}
