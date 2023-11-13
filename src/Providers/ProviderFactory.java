package Providers;

import Providers.AccountProviders.IProvider;
import Registeration_service.Factories.BankFactory;
import Registeration_service.Factories.WalletFactory;
import User.model.Account;

public class ProviderFactory {

    public IProvider CreateProvider(String type , String providerType) {
        return switch (type) {
            case "Bank" -> new BankFactory().CreateBank(providerType);
            case "Wallet" -> new WalletFactory().CreateWallet(providerType);
            default -> null;
        };
    }

    public String getProviderType(Account account) {
        String type = account.getClass().getName();
        System.out.println(type);
        return switch (type) {
            case "BankAccount" -> "Bank";
            case "WalletAccount" -> "Wallet";
            default -> null;
        };
    }
}
