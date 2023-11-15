package RegisterationService.Controllers.AccountRegistration;

import Entities.User.Account;
import Entities.User.Factories.BankFactory;
import Entities.User.User;
import InstapayApplication.Utilites.InstapayUtilites;
import Providers.AccountProviders.IProvider;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class BankRegistration extends AccountRegistration {
    @Override
    public Map.Entry<Account, IProvider> Register() {
        while (true){
            IProvider provider = InstapayUtilites.GenericSelection(new BankFactory() , "Bank Provider");
            if(provider == null) return null;
            String phoneNumber = Verify(provider , "Bank Account");
            if(phoneNumber == null) continue;
            Account account = provider.getAccount(phoneNumber);
            return new AbstractMap.SimpleEntry<>(account,provider);
        }
    }

}
