package TransactionService;

import Entities.User.Account;
import Entities.User.BankAccount;
import Entities.User.WalletAccount;
import TransactionService.TransferValidator;

/**
 * WalletToBankValidator
 */
public class WalletToBankValidator implements TransferValidator {
    public boolean Validate(Account srcAccount, Account distAccount) {
        boolean isValid = !(srcAccount instanceof WalletAccount && distAccount instanceof BankAccount);
        if (!isValid) {
            System.out.println("Cannot transfer from a Wallet to Bank!!");
        }
        return isValid;
    }
}