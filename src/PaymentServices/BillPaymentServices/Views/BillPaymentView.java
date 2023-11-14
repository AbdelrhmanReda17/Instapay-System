package PaymentServices.BillPaymentServices.Views;

import InstapayApplication.Utilites.InstapayUtilites;
import Providers.BillProviders.BillProvider;
import Entities.Bills.Factories.BillProvidersFactory;

import java.util.Set;

public class BillPaymentView {
    public static BillProvider BillSelection(){
        while (true){
            BillProvidersFactory billProvidersFactory=new BillProvidersFactory();
            Set<String> billProvidersFactoryArray = billProvidersFactory.GetBillProviders();
            int choice = InstapayUtilites.GenericMenu(billProvidersFactoryArray , "Bill");
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
