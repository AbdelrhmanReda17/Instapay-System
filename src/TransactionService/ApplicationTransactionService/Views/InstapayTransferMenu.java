package TransactionService.ApplicationTransactionService.Views;

import Entities.User.Factories.BankFactory;
import Entities.User.Factories.WalletFactory;
import InstapayApplication.Utilites.InstapayUtilites;
import TransactionService.TransferMenuView;


public class InstapayTransferMenu extends TransferMenuView {
    @Override
    public String[] Display() {
        //first index is Instapay Account Number, Second Index is amount.
        String[] data = {"", ""};
        System.out.print("Please enter the instapay account number : ");
        data[0] = InstapayUtilites.TakeInput(String.class, "" , "");
        if(data[0].equals("Exit") ) return null;
        System.out.print("Please enter the amount: ");
        double amount = InstapayUtilites.TakeInput(Double.class, "^\\\\d+(\\\\.\\\\d+)?$" , "");
        if(amount == 0) return null;
        data[1] = String.valueOf(amount);
        return data;
    }
}
