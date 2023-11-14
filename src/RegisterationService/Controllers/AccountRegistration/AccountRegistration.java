package RegisterationService.Controllers.AccountRegistration;

import Entities.User.Account;
import Entities.User.User;
import Providers.AccountProviders.IProvider;

import java.util.Map;

public interface AccountRegistration {
    public Map.Entry<Account, IProvider> Register();
}
