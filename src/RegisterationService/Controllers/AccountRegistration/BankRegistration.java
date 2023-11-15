package RegisterationService.Controllers.AccountRegistration;

import InstapayApplication.Entities.User.Account;
import Providers.Factories.BankProviderFactory;
import Utilites.InstapayUtilites;
import Providers.AccountProviders.IProvider;

import java.util.AbstractMap;
import java.util.Map;

public class BankRegistration extends AccountRegistration {
    @Override
    public Map.Entry<Account, IProvider> Register() {
        while (true){
            IProvider provider = InstapayUtilites.GenericSelection(new BankProviderFactory() , "Bank Provider");
            if(provider == null) return null;
            String phoneNumber = Verify(provider , "Bank Account");
            if(phoneNumber == null) continue;
            Account account = provider.getAccount(phoneNumber);
            return new AbstractMap.SimpleEntry<>(account,provider);
        }
    }

}
