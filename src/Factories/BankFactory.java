package Factories;

import Providers.BankProvider;
import Providers.Banks.CIBProvider;
import Providers.Banks.QNBProvider;

public class BankFactory {
    public BankProvider CreateBank(String type) {
        return switch (type) {
            case "CIB" -> new CIBProvider();
            case "QNB" -> new QNBProvider();
            default -> null;
        };
    }
}
