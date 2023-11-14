package Transaction_Service.view.Transfer;

import Entities.User.User;
import InstapayApplication.Utilites.InstapayUtilites;
import Transaction_Service.Controllers.TransferController;

public class BankAccountTransferView implements TransferView{
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
