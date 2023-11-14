package TransactionService.WalletTransactionService.Controllers;

import Entities.User.Account;
import Entities.User.User;
import Providers.AccountProviders.IProvider;
import TransactionService.TransferController;

public class WalletTransferController extends TransferController {
    @Override
    public Account ParseUserData(String userData, IProvider provider) {
        return null;
    }
}
