package InstapayApplication.Controller;

import InstapayApplication.Entities.User.User;
import Utilites.InstapayUtilites;
import InstapayApplication.Views.Factories.ViewFactory;
import PaymentServices.BillPaymentServices.Controllers.BillPaymentServices;
import PaymentServices.IPaymentServices;
import Providers.AccountProviders.IProvider;
import TransactionService.Factories.TransferControllerFactory;
import TransactionService.Factories.TransferMenuFactory;

public class MainMenuController {
    public static void Display(User user, IProvider provider) {
        while (true) {
            int choice = ViewFactory.CreateMainMenu(user.getAccount()).DisplayMenu();
            switch (choice) {
                case 1:
                    InstapayUtilites.Splitter();
                    System.out.println("User balance: " + user.getAccount().getAmount());
                    break;
                case 2:
                    InstapayUtilites.Splitter();
                    IPaymentServices ar = new BillPaymentServices();
                    ar.Pay(user.getAccount(),provider);
                    break;
                case 3,4,5:
                    InstapayUtilites.Splitter();
                    TransferControllerFactory.CreateTransferController(choice).Transfer(TransferMenuFactory.CreateTransferViewMenu(choice) , user.getAccount() , provider);
                    break;
                case 0:
                    return;
            }
        }
    }
}
