package Transaction_Service.Controllers;

import User.model.Account;

public interface TransferValidator {
    public boolean Validate(Account srcAccount, Account distAccount);
}
