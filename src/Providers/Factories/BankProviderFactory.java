package Providers.Factories;

import Providers.AccountProviders.Banks.CIBProvider;
import Providers.AccountProviders.Banks.QNBProvider;

public class BankProviderFactory extends AccountProviderFactory {
    public BankProviderFactory() {
        AccountProviders.put("CIB" , bankProvider -> new CIBProvider());
        AccountProviders.put("QNB" , bankProvider -> new QNBProvider());
    }

}
