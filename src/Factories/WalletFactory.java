package Factories;

import Providers.WalletProvider;
import Providers.Wallets.*;

public class WalletFactory {
    public WalletProvider CreateWallet(String type) {
        return switch (type) {
            case "CIB" -> new VodafoneProvider();
            case "QNB" -> new FawryProvider();
            default -> null;
        };
    }
}
