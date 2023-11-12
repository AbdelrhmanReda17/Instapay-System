package Controllers;

import User.*;

public abstract class TransferController {
    protected DataController dataController = new DataController();
    public boolean Transfer(User srcAccount, String AccountTwoData, double ammount) {
           User distAccount = ParseUserData(AccountTwoData);
           if (distAccount == null) {
               return false;
           }
           
           if (TransferHandler(srcAccount.getAccount(), distAccount.getAccount(), ammount)) {
               return true;
           }
           else {
            return false;
           }
    }

    public abstract User ParseUserData(String userData);

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
    //violate open close 
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
