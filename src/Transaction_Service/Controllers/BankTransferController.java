package Transaction_Service.Controllers;

import Entities.User.User;
import Providers.AccountProviders.IProvider;

public class BankTransferController extends TransferController{

    @Override
    public Account ParseUserData(String userData, IProvider provider) {
        User distAccount = provider.getAccount(userData);
        if (distAccount == null) return null;
        return distAccount.getAccount();
    }

}
