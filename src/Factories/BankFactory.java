package Factories;

import java.util.HashMap;
import Providers.AccountProviders.BankProvider;
import Providers.AccountProviders.Banks.CIBProvider;
import Providers.AccountProviders.Banks.QNBProvider;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class BankFactory {
    private Map<String , Function<Void,BankProvider>> BankProviders = new HashMap<>();

    public BankFactory() {
        BankProviders.put("CIB" , bankProvider -> {
            return new CIBProvider();
        });
        BankProviders.put("QNB" , bankProvider -> {
            return new QNBProvider();
        });
    }
    public BankProvider CreateBank(String type) {
        return BankProviders.get(type).apply(null);
    }

    public Set<String> GetBankProviders() {
        return BankProviders.keySet();
    }
}
