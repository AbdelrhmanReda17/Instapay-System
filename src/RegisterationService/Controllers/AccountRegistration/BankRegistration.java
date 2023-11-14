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
            IProvider provider = BankSelection();
            if(provider == null) return null;
            String bankId = Authentication.Verify(provider);
            if(bankId == null) continue;
            Account acc=provider.getAccount(bankId);
            return new AbstractMap.SimpleEntry<>(acc,provider);
        }
    }
    public IProvider BankSelection(){
        BankFactory bankFactory = new BankFactory();
        Set<String> bankFactoryArray = bankFactory.GetBankProviders();
        int choice = InstapayUtilites.GenericMenu(bankFactoryArray , "Bank Provider");
        if (choice == 0) {
            return null;
        }
        return bankFactory.CreateBank(bankFactoryArray.toArray()[choice - 1].toString());
    }

}
