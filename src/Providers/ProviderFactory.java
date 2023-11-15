package Providers;

import Providers.AccountProviders.IProvider;
import Entities.User.Factories.BankFactory;
import Entities.User.Factories.WalletFactory;
import Entities.User.Account;

public class ProviderFactory {

    public IProvider CreateProvider(String type , String providerType) {
        return switch (type) {
            case "Bank" -> new BankFactory().CreateProvider(providerType);
            case "Wallet" -> new WalletFactory().CreateProvider(providerType);
            default -> null;
        };
    }

    public String getProviderType(Account account) {
        String type = account.getClass().getName();
        return switch (type) {
            case "BankAccount" -> "Bank";
            case "WalletAccount" -> "Wallet";
            default -> null;
        };
    }
}
