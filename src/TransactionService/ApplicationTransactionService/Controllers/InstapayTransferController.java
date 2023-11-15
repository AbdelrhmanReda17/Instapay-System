package TransactionService.ApplicationTransactionService.Controllers;

import Entities.User.Account;
import Entities.User.User;
import InstapayDatabase.DataManager;
import Providers.AccountProviders.IProvider;
import TransactionService.TransferController;

import java.util.Map;

public class InstapayTransferController extends TransferController {
    @Override
    public Map.Entry<Account , IProvider> ParseUserData(IProvider provider,String[] data){
        DataManager dataManager = new DataManager();
        Map.Entry<User,IProvider> entry = dataManager.GetUserByID(data[0]);
        if(entry == null) return null;
        return Map.entry(entry.getKey().getAccount(),entry.getValue());
    }
}
