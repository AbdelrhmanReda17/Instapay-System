package Entities.User.Factories;

import Providers.AccountProviders.BankProvider;
import Providers.AccountProviders.Banks.CIBProvider;
import Providers.AccountProviders.Banks.QNBProvider;
import Providers.AccountProviders.WalletProvider;
import Providers.AccountProviders.Wallets.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class WalletFactory {
    private Map<String , Function<Void, WalletProvider>> walletProviders = new HashMap<>();

    public WalletFactory() {
        walletProviders.put("Vodafone" , bankProvider -> {
            return new VodafoneProvider();
        });
        walletProviders.put("Fawry" , bankProvider -> {
            return new FawryProvider();
        });
    }
    public WalletProvider CreateWallet(String type) {
        System.out.println(walletProviders.get(type).apply(null).getName());
        return walletProviders.get(type).apply(null);
    }

    public Set<String> GetWalletProviders() {
        return walletProviders.keySet();
    }
}
