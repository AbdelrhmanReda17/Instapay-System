package TransactionService;

import Entities.User.Account;

public interface TransferValidator {
    public boolean Validate(Account srcAccount, Account distAccount);
}
