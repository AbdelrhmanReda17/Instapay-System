package Entities.User.Factories;

import java.util.HashMap;
import Providers.AccountProviders.BankProvider;
import Providers.AccountProviders.Banks.CIBProvider;
import Providers.AccountProviders.Banks.QNBProvider;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class BankFactory extends AccountFactory {
    public BankFactory() {
        AccountProviders.put("CIB" , bankProvider -> new CIBProvider());
        AccountProviders.put("QNB" , bankProvider -> new QNBProvider());
    }

}
