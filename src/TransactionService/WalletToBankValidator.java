package TransactionService;

import InstapayApplication.Entities.User.Account;
import InstapayApplication.Entities.User.BankAccount;
import InstapayApplication.Entities.User.WalletAccount;

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