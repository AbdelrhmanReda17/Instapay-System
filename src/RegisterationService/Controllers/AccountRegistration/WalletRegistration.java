package RegisterationService.Controllers.AccountRegistration;

import Entities.User.Account;
import Entities.User.Factories.WalletFactory;
import InstapayApplication.Utilites.InstapayUtilites;
import Providers.AccountProviders.IProvider;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class WalletRegistration implements AccountRegistration {
    @Override
    public  Map.Entry<Account, IProvider> Register() {
        while (true){
            IProvider provider = WalletSelection();
            if(provider == null) return null;
            String bankId = Authentication.Verify(provider);
            if(bankId == null) continue;
            Account acc =provider.getAccount(bankId);
            return new AbstractMap.SimpleEntry<>(acc,provider);
        }
    }
    public IProvider WalletSelection(){
        WalletFactory walletFactory = new WalletFactory();
        Set<String> walletFactoryArray = walletFactory.GetWalletProviders();
        int choice = InstapayUtilites.GenericMenu(walletFactoryArray , "Wallet Provider");
        if (choice == 0) {
            return null;
        }
        return walletFactory.CreateWallet(walletFactoryArray.toArray()[choice - 1].toString());
    }
}
