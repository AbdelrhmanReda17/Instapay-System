package Controllers;

import User.User;

public class InstapayTransferController extends TransferController {

    @Override
    public User ParseUserData(String userData) {
        //user distAccount = dataController.getAccount(userData);
        //Account.getAccountType(); => "Bank  / Wallet" => Factory => createProvider('Bank') => IProvider => IProvider.verify("asdadasdas");
        return new User();
    }

}
