package InstapayApplication.Entities.User.Factories;

import Providers.AccountProviders.Banks.CIBProvider;
import Providers.AccountProviders.Banks.QNBProvider;

public class BankFactory extends AccountFactory {
    public BankFactory() {
        AccountProviders.put("CIB" , bankProvider -> new CIBProvider());
        AccountProviders.put("QNB" , bankProvider -> new QNBProvider());
    }

}
