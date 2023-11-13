package Transaction_Service.Controllers;

import Model.AccountsManger;
import User.model.Account;
import User.model.BankAccount;
import User.model.User;
import User.model.WalletAccount;

public abstract class TransferController {
    protected AccountsManger accountsManger = new AccountsManger();
    public boolean Transfer(User srcAccount, String AccountTwoData, double ammount) {
           User distAccount = ParseUserData(AccountTwoData);
           if (distAccount == null) {
               return false;
           }
           
           return TransferHandler(srcAccount.getAccount(), distAccount.getAccount(), ammount);

    }

    public abstract User ParseUserData(String userData);

    private boolean TransferHandler(Account srcAccount , Account distAccount, double ammount) {
        if (!isValidTransaction(srcAccount, distAccount)) {
            return false;
        }

        srcAccount = srcAccount.getProvider().Withdraw(srcAccount, ammount);
        if (srcAccount != null) {
            distAccount = distAccount.getProvider().Deposit(distAccount, ammount);
            return true;
        }
        else {
            return false;
        }
    }
    //violate open close 
    private boolean isValidTransaction(Account srAccount, Account distAccount) {
        return !(srAccount instanceof WalletAccount) || !(distAccount instanceof BankAccount);
    }
}
