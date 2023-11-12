package Factories;

import Providers.IProvider;

public class ProviderFactory {
    public IProvider CreateProvider(String type , String providerType) {
        return switch (type) {
            case "Bank" -> new BankFactory().CreateBank(providerType);
            case "Wallet" -> new WalletFactory().CreateWallet(providerType);
            default -> null;
        };
    }
}
