package TransactionService.WalletTransactionService.Controllers;

import Entities.User.Account;
import Entities.User.BankAccount;
import Entities.User.WalletAccount;
import TransactionService.TransferValidator;

/**
 * WalletToBankValidator
 */
public class WalletToBankValidator implements TransferValidator {
    public boolean Validate(Account srcAccount, Account distAccount) {
        return !(srcAccount instanceof WalletAccount && distAccount instanceof BankAccount);
    }
}