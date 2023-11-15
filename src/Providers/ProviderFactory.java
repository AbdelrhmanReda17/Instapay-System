package Providers;

import Providers.AccountProviders.IProvider;
import InstapayApplication.Entities.User.Factories.BankFactory;
import InstapayApplication.Entities.User.Factories.WalletFactory;
import InstapayApplication.Entities.User.Account;

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
