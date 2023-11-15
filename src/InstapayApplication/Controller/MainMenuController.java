package InstapayApplication.Controller;

import Entities.User.User;
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
                    System.out.println("------------------------------------");
                    System.out.println("User balance: " + user.getAccount().getAmount());
                    System.out.println("------------------------------------");
                    break;
                case 2:
                    IPaymentServices ar = new BillPaymentServices();
                    ar.Pay(user.getAccount(),provider);
                    break;
                case 3,4,5:
                    TransferControllerFactory.CreateTransferController(choice).Transfer(TransferMenuFactory.CreateTransferViewMenu(choice) , user.getAccount() , provider);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("AR");
                    break;
            }
        }
    }
}
