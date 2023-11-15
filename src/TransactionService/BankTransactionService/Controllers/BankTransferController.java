package TransactionService.BankTransactionService.Controllers;

import InstapayApplication.Entities.User.Account;
import Providers.AccountProviders.IProvider;
import TransactionService.TransferController;

import java.util.Map;

public class BankTransferController extends TransferController {
    @Override
    public Map.Entry<Account,IProvider> ParseUserData(IProvider provider,String[] data){
        Account account = provider.getAccount(data[0]);
        if(account == null) return null;
        return Map.entry(account , provider);
    }
}
