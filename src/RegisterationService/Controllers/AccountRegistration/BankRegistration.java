package RegisterationService.Controllers.AccountRegistration;

import Entities.User.Account;
import Entities.User.Factories.BankFactory;
import InstapayApplication.Utilites.InstapayUtilites;
import Providers.AccountProviders.IProvider;
import RegisterationService.Views.RegisterView;

import java.util.Set;

public class BankRegistration implements AccountRegistration {
    @Override
    public Account Register() {
        while (true){
            IProvider provider = BankSelection();
            if(provider == null) return null;
            String bankId = Authentication.Verify(provider);
            if(bankId == null) continue;
            return provider.getAccount(bankId);
        }
    }
    public IProvider BankSelection(){
        BankFactory bankFactory = new BankFactory();
        Set<String> bankFactoryArray = bankFactory.GetBankProviders();
        int choice = InstapayUtilites.ProviderMenu(bankFactoryArray);
        if (choice == 0) {
            return null;
        }
        return bankFactory.CreateBank(bankFactoryArray.toArray()[choice - 1].toString());
    }

}
