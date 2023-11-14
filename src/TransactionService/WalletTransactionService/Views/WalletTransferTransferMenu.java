package TransactionService.WalletTransactionService.Views;

import Entities.User.Factories.WalletFactory;
import Entities.User.User;
import InstapayApplication.Utilites.InstapayUtilites;
import Providers.AccountProviders.IProvider;
import TransactionService.TransferController;
import TransactionService.TransferMenuView;

/**
 * WalletTransferView
 */
public class WalletTransferTransferMenu implements TransferMenuView {

    @Override
    public void Transfer(TransferController transferController, User user) {
        WalletFactory walletFactory = new WalletFactory();
        int choice = InstapayUtilites.GenericMenu(walletFactory.GetWalletProviders() , "Wallet Provider");
        IProvider provider = walletFactory.CreateWallet(walletFactory.GetWalletProviders().toArray()[choice - 1].toString());
        if (provider == null) 
            return;
        
        System.out.print("Please enter the mobile number: ");
        String mobileNumber = InstapayUtilites.TakeInput(String.class, "" , "");
        System.out.print("Please enter the amount: ");
        double amount = InstapayUtilites.TakeInput(Double.class, "" , "");
        if (transferController.Transfer(user.getAccount() , mobileNumber , amount)) {
            System.out.println("Transfer completed successfully");
        }
    }


}