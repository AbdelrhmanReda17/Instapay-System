package TransactionService;

import InstapayDatabase.DataManager;
import Providers.AccountProviders.IProvider;
import Entities.User.Account;
import Entities.User.User;
import TransactionService.WalletTransactionService.Controllers.WalletToBankValidator;

public abstract class TransferController {
    private TransferValidator validator = new WalletToBankValidator();
    protected DataManager accountsManger = new DataManager();
    public abstract Account ParseUserData(String userData, IProvider provider);
    public boolean Transfer(Account srcAccount , String distAccountData , double ammount) {
        return false;
    }
    public boolean TransferHandler(Account srcAccount, Account distAccount, double amount) {
        if (srcAccount.getProvider().Withdraw(srcAccount, amount)) {
            distAccount.getProvider().Deposit(distAccount, amount);
            return true;
        }
        else {
            return false;
        }
    }
}
