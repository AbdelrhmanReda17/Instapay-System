package TransactionService.WalletTransactionService.Views;

import InstapayApplication.Entities.User.Factories.WalletFactory;
import Utilites.InstapayUtilites;
import TransactionService.TransferMenuView;

/**
 * WalletTransferView
 */
public class WalletTransferTransferMenu extends TransferMenuView {
    public String[] Display() {
        //Third index is mobile number and second is amount.
        distUserProvider = InstapayUtilites.GenericSelection(new WalletFactory() , "Wallet Provider");
        if(distUserProvider == null) return null;
        String[] data = {"", ""};
        System.out.print("Please enter the mobile number: ");
        data[0] = InstapayUtilites.TakeInput(String.class, "" , "");
        if(data[0].equals("Exit") ) return null;
        System.out.print("Please enter the amount: ");
        double amount = InstapayUtilites.TakeInput(Double.class, "" , "");
        if(amount == 0) return null;
        data[1] = String.valueOf(amount);
        return data;
    }
}