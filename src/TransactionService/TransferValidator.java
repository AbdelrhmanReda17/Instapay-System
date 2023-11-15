package TransactionService;

import InstapayApplication.Entities.User.Account;

public interface TransferValidator {
    public boolean Validate(Account srcAccount, Account distAccount);
}
