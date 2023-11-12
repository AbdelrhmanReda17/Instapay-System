package Factories;

import Providers.AccountProviders.BankProvider;
import Providers.AccountProviders.Banks.CIBProvider;
import Providers.AccountProviders.Banks.QNBProvider;

public class BankFactory {
    public BankProvider CreateBank(String type) {
        return switch (type) {
            case "CIB" -> new CIBProvider();
            case "QNB" -> new QNBProvider();
            default -> null;
        };
    }
}
