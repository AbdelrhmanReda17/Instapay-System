package TransactionService.BankTransactionService.Views;

import Entities.User.Factories.BankFactory;
import InstapayApplication.Utilites.InstapayUtilites;
import TransactionService.TransferMenuView;

public class BankAccountTransferMenu extends TransferMenuView {
    public String[] Display() {
        //first Index is MobileNumber and second is amount.
        distUserProvider = InstapayUtilites.GenericSelection(new BankFactory());
        if(distUserProvider == null) return null;
        String[] data = {"", ""};
        System.out.print("Please enter the Bank account ID: ");
        data[0] = InstapayUtilites.TakeInput(String.class, "" , "");
        if(data[0].equals("Exit") ) return null;
        System.out.print("Please enter the amount: ");
        double amount = InstapayUtilites.TakeInput(Double.class, "" , "");
        if(amount == 0) return null;
        data[1] = String.valueOf(amount);
        return data;
    }
}
