package Transaction_Service.Controllers;

import User.model.User;

public class WalletTransferController extends TransferController {

    @Override
    public User ParseUserData(String userData) {
        //user distAccount = dataController.getAccountByPhoneNumber(userData);
        //Account.getAccountType(); => "Bank  / Wallet" => Factory => createProvider('Bank') => IProvider => IProvider.verify("asdadasdas");
        return new User();
    }

}
