package Entities.User.Factories;


import Providers.AccountProviders.WalletProvider;
import Providers.AccountProviders.Wallets.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class WalletFactory extends AccountFactory {
    public WalletFactory() {
        AccountProviders.put("Vodafone" , bankProvider -> new VodafoneProvider());
        AccountProviders.put("Fawry" , bankProvider -> new FawryProvider());
    }
}
