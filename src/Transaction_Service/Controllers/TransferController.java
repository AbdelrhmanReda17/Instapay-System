package Transaction_Service.Controllers;

import Model.AccountsManger;
import Providers.AccountProviders.IProvider;
import User.model.Account;
import User.model.BankAccount;
import User.model.User;
import User.model.WalletAccount;

public abstract class TransferController {
    protected IProvider provider;
    private TransferValidator validator = new WalletToBankValidator();
    protected AccountsManger accountsManger = new AccountsManger();

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
