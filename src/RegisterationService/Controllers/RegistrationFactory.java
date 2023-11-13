package RegisterationService.Controllers;

import Entities.User.Account;
import RegisterationService.Controllers.AccountRegistration.BankRegistration;
import RegisterationService.Controllers.AccountRegistration.WalletRegistration;


public class RegistrationFactory {
    public static Account createRegistration(int type) {
        if (type == 1) return new BankRegistration().Register();
        else if (type == 2) return new WalletRegistration().Register();
        return null;
    }
}
