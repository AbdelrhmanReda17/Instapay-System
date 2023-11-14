package TransactionService.ApplicationTransactionService.Controllers;

import Entities.User.Account;
import Entities.User.User;
import Providers.AccountProviders.IProvider;
import TransactionService.TransferController;

public class InstapayTransferController extends TransferController {

    public InstapayTransferController() {
        
    }
    @Override
    public Account ParseUserData(String userData, IProvider provider) {
        return null;
    }
}
