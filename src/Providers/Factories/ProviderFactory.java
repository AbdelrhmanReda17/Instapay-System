package Providers.Factories;

import Providers.AccountProviders.IProvider;
import Providers.Factories.BankProviderFactory;
import Providers.Factories.WalletProviderFactory;
import InstapayApplication.Entities.User.Account;

public class ProviderFactory {

    public IProvider CreateProvider(String type , String providerType) {
        return switch (type) {
            case "Bank" -> new BankProviderFactory().CreateProvider(providerType);
            case "Wallet" -> new WalletProviderFactory().CreateProvider(providerType);
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
