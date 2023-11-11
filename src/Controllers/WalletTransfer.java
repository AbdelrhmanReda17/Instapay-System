package Controllers;

import User.Account;
import User.User;

public class WalletTransfer extends TransferController {

    @Override
    public User ParseUserData(String userData) {
        //user distAccount = dataController.getAccountByPhoneNumber(userData);
        //Account.getAccountType(); => "Bank  / Wallet" => Factory => createProvider('Bank') => IProvider => IProvider.verify("asdadasdas");
        return new User();
    }

}
