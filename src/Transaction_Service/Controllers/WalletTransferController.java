package Transaction_Service.Controllers;

import Entities.User.User;

public class WalletTransferController extends TransferController {

    @Override
    public User ParseUserData(String userData) {
        //User distAccount = provider.getAccount(userData);
        //Account.getAccountType(); => "Bank  / Wallet" => Factory => createProvider('Bank') => IProvider => IProvider.verify("asdadasdas");
        return new User();
    }

}
