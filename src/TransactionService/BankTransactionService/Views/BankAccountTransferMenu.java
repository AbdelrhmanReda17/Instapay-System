package TransactionService.BankTransactionService.Views;

import Entities.User.User;
import InstapayApplication.Utilites.InstapayUtilites;
import TransactionService.TransferController;
import TransactionService.TransferMenuView;

public class BankAccountTransferMenu implements TransferMenuView {
    @Override
    public void Transfer(TransferController transferController, User user) {
        System.out.print("Please enter the account number number: ");
        String accountNumber = InstapayUtilites.TakeInput(String.class, "" , "");
        System.out.print("Please enter the amount: ");
        double amount = InstapayUtilites.TakeInput(Double.class, "" , "");
        if (transferController.Transfer(user.getAccount() , accountNumber , amount)) {
            System.out.println("Transfer completed successfully");
        }
    }
}
