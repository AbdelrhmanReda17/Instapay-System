package Controllers;

import User.*;

public class TransferController {
    public boolean Transfer(Account srcAccount ,Account distAccount, double ammount) {
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
