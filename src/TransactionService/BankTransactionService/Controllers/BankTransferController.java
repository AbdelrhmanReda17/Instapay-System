package TransactionService.BankTransactionService.Controllers;

import Entities.User.Account;
import Entities.User.User;
import Providers.AccountProviders.IProvider;
import TransactionService.TransferController;

public class BankTransferController extends TransferController {

    @Override
    public Account ParseUserData(String userData, IProvider provider) {
        Account distAccount = provider.getAccount(userData);
        if (distAccount == null) return null;
        return distAccount;
    }

}
