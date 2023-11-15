package TransactionService;

import InstapayDatabase.DataManager;
import Providers.AccountProviders.IProvider;
import Entities.User.Account;
import Entities.User.User;
import TransactionService.WalletTransactionService.Controllers.WalletToBankValidator;

import java.util.Map;

public abstract class TransferController {
    private final TransferValidator validator = new WalletToBankValidator();
    protected DataManager accountsManger = new DataManager();
    public abstract Map.Entry<Account,IProvider> ParseUserData(IProvider provider,String[] data);
    public boolean Transfer(TransferMenuView menuView, User user, IProvider srcProvider) {
        String[] userInput = menuView.Display();

        return userInput != null && TransferHandler(user.getAccount(),srcProvider,userInput,menuView.getDistUserProvider());
    }
    public boolean TransferHandler(Account srcAccount,IProvider srcProvider, String[] userInputData,IProvider distUserProvider) {
        Map.Entry<Account,IProvider> distUser = ParseUserData(distUserProvider, userInputData);
        double amount = Double.parseDouble(userInputData[1]);
        if (srcProvider.Withdraw(srcAccount, amount)) {
            distUser.getValue().Deposit(distUser.getKey(), amount);
            return true;
        }
        else {
            return false;
        }
    }
}
