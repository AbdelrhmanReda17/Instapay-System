package RegisterationService.Controllers;

import InstapayApplication.Entities.User.Account;
import Providers.AccountProviders.IProvider;
import RegisterationService.Controllers.AccountRegistration.*;

import java.util.Map;


public class RegistrationFactory {
    public static  Map.Entry<Account, IProvider> createRegistration(int type) {
        if(type == 1) return new BankRegistration().Register();
        else if (type == 2) return new WalletRegistration().Register();
        return null;
    }
}
