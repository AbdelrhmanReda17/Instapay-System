package InstapayApplication.Entities.User.Factories;


import Providers.AccountProviders.Wallets.*;

public class WalletFactory extends AccountFactory {
    public WalletFactory() {
        AccountProviders.put("Vodafone" , bankProvider -> new VodafoneProvider());
        AccountProviders.put("Fawry" , bankProvider -> new FawryProvider());
    }
}
