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
//                        user.getAccount().Display();
                    break;
                case 2:
                    IPaymentServices ar = new BillPaymentServices();
                    ar.Pay(user.getAccount(),provider);
                    break;
                case 3,4,5:
                    //TransferMenuFactory.CreateTransferViewMenu(choice).Transfer(TransferControllerFactory.CreateTransferController(choice) ,user, provider);
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
