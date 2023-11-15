package Providers.Factories;


import Providers.AccountProviders.Wallets.*;

public class WalletProviderFactory extends AccountProviderFactory {
    public WalletProviderFactory() {
        AccountProviders.put("Vodafone" , bankProvider -> new VodafoneProvider());
        AccountProviders.put("Fawry" , bankProvider -> new FawryProvider());
    }
}
