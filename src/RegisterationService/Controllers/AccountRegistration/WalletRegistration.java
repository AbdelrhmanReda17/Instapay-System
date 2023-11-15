package RegisterationService.Controllers.AccountRegistration;

import InstapayApplication.Entities.User.Account;
import Providers.Factories.WalletProviderFactory;
import Utilites.InstapayUtilites;
import Providers.AccountProviders.IProvider;

import java.util.AbstractMap;
import java.util.Map;

public class WalletRegistration extends AccountRegistration {
    @Override
    public  Map.Entry<Account, IProvider> Register() {
        while (true){
            IProvider provider = InstapayUtilites.GenericSelection(new WalletProviderFactory() , "Wallet Provider");
            if(provider == null) return null;
            String bankId = Verify(provider , "Wallet Account");
            if(bankId == null) continue;
            Account acc = provider.getAccount(bankId);
            return new AbstractMap.SimpleEntry<>(acc,provider);
        }
    }

}
