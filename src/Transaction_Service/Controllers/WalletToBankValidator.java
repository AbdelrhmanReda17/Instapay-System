package Transaction_Service.Controllers;

import User.model.Account;
import User.model.BankAccount;
import User.model.WalletAccount;

/**
 * WalletToBankValidator
 */
public class WalletToBankValidator implements TransferValidator {

    public boolean Validate(Account srcAccount, Account distAccount) {
        return !(srcAccount instanceof WalletAccount && distAccount instanceof BankAccount);
    }
}