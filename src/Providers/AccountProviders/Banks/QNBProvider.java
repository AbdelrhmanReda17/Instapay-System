package Providers.AccountProviders.Banks;

import Providers.AccountProviders.BankProvider;
import User.Account;

public class QNBProvider extends BankProvider {
    private final String Name = "QNB";

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
