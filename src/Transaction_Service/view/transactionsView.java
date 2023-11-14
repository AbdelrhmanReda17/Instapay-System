package Transaction_Service.view;

import java.util.Set;
import Entities.User.User;
import InstapayApplication.Utilites.InstapayUtilites;
import Providers.BillProviders.BillProvider;
import Transaction_Service.Controllers.BillProvidersFactory;


public class transactionsView {
    public static int transactionsMenu(User user){
        return ViewFactory.CreateTransactionMenu(user.getAccount()).ViewMenu();
    }

    public static BillProvider BillSelection(){
        System.out.println("Please Select your Bill To Pay : ");
        BillProvidersFactory billProvidersFactory=new BillProvidersFactory();
        Set<String> billProvidersFactoryArray = billProvidersFactory.GetBillProviders();
        for (int i = 1; i < billProvidersFactoryArray.size() + 1; i++){
            System.out.println(i + ". " + billProvidersFactoryArray.toArray()[i - 1]);
        }
        System.out.println("0. Exit");
        System.out.print("Please select an option [0 - "+ billProvidersFactoryArray.size() +"]: ");

        while (true){
            int choice = InstapayUtilites.TakeInput(Integer.class , "","" );
            if (choice == 0) {
                return  null;
            }
            else if (choice > 0 && choice <= billProvidersFactoryArray.size()) {
                return BillProvidersFactory.CreateBillProvider(billProvidersFactoryArray.toArray()[choice - 1].toString());
            }
            else {
                System.out.println("Invalid input, please enter a number between [0 - "+ billProvidersFactoryArray.size() +"]: ");
            }
        }

    }


}
