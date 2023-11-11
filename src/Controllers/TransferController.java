package Controllers;

import Providers.IProvider;
import User.*;

public abstract class TransferController {
    private DataController dataController = new DataController();
    private IProvider provider;
    public abstract void Transfer(User srcAccount, String AccountTwoData, double ammount);
    //        user distAccount = dataController.getAccount(AccountTwoData);
    //        Account.getAccountType(); => "Bank  / Wallet" => Factory => createProvider('Bank') => IProvider => IProvider.verify("asdadasdas");
    //        if (distAccount == null) {
    //            return;
    //        }
    //        if (TransferHandler(srcAccount, distAccount, ammount)) {
    //            provider.Verify();
    //        }
    private boolean TransferHandler(Account srcAccount ,Account distAccount, double ammount) {
        if (!isValidTransaction(srcAccount, distAccount)) {
            return false;
        }

        if (distAccount.Withdraw(ammount)) {
            srcAccount.Deposit(ammount);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isValidTransaction(Account srAccount, Account distAccount) {
        if (srAccount == null || distAccount == null) {
            return false;
        }
        else if (srAccount instanceof WalletAccount && distAccount instanceof BankAccount) {
            return false;
        }
        else {
            return true;
        }
    }
}
