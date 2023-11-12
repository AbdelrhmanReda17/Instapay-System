package Factories;

import Providers.AccountProviders.WalletProvider;
import Providers.AccountProviders.Wallets.*;

public class WalletFactory {
    public WalletProvider CreateWallet(String type) {
        return switch (type) {
            case "Vodafone" -> new VodafoneProvider();
            case "Fawry" -> new FawryProvider();
            default -> null;
        };
    }
}
