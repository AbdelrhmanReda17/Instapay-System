package InstapayApplication.Controller;

import Entities.User.User;
import InstapayApplication.Views.Factories.ViewFactory;
import PaymentServices.BillPaymentServices.Controllers.BillPaymentServices;
import PaymentServices.IPaymentServices;
import TransactionService.Factories.TransferControllerFactory;
import TransactionService.Factories.TransferMenuFactory;

public class MainMenuController {
    public static void Display(User user) {
        while (true) {
            int choice = ViewFactory.CreateMainMenu(user.getAccount()).DisplayMenu();
            switch (choice) {
                case 1:
//                        user.getAccount().Display();
                    break;
                case 2:
                    IPaymentServices ar = new BillPaymentServices();
                    ar.Pay(user.getAccount());
                    break;
                case 3,4,5:
                    TransferMenuFactory.CreateTransferViewMenu(choice).Transfer(TransferControllerFactory.CreateTransferController(choice) ,user);
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
