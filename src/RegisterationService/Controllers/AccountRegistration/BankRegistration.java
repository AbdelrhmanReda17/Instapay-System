package RegisterationService.Controllers.AccountRegistration;

import Entities.User.Account;
import Entities.User.Factories.BankFactory;
import Entities.User.User;
import InstapayApplication.Utilites.InstapayUtilites;
import Providers.AccountProviders.IProvider;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class BankRegistration implements AccountRegistration {
    @Override
    public Map.Entry<Account, IProvider> Register() {
        while (true){
            IProvider provider = InstapayUtilites.GenericSelection(new BankFactory());
            if(provider == null) return null;
            String bankId = Authentication.Verify(provider);
            if(bankId == null) continue;
            Account acc=provider.getAccount(bankId);
            return new AbstractMap.SimpleEntry<>(acc,provider);
        }
    }

}
