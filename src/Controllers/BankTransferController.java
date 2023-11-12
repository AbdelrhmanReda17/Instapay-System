package Controllers;

import User.Account;
import User.User;

public class BankTransferController extends TransferController{

    @Override
    public User ParseUserData(String userData) {
        //User distAccount = dataController.getAccountByBankId(userData);
        //Account.getAccountType(); => "Bank  / Wallet" => Factory => createProvider('Bank') => IProvider => IProvider.verify("asdadasdas");
        return new User();
    }

}
