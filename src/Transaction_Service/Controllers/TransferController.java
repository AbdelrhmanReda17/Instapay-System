package Transaction_Service.Controllers;

import InstapayDatabase.DataManager;
import Providers.AccountProviders.IProvider;
import Entities.User.Account;
import Entities.User.User;

public abstract class TransferController {
    protected IProvider provider;
    private TransferValidator validator = new WalletToBankValidator();
    protected DataManager accountsManger = new DataManager();

    public abstract User ParseUserData(String userData);

    public boolean Transfer(Account srcAccount , String distAccountData , double ammount) {
        User distAccount = ParseUserData(distAccountData);

        if (distAccount == null || !validator.Validate(srcAccount, distAccount.getAccount())) {
            return false;
        }

        provider.Transfer(srcAccount, distAccount.getAccount(), ammount);
        return true;
    }
}
