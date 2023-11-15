package PaymentServices.BillPaymentServices.Views;

import Entities.Bills.Bill;
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
    public static boolean ConfirmPayment(){
        System.out.print("Do you want proceed Payment ?: ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int choice = InstapayUtilites.TakeInput(Integer.class , "[1-2]","Invalid choice");
        return choice == 1;

    }
    public static Bill CheckBill(BillProvider billProvider){
        System.out.print("Please Enter the Id: ");
        int billId = InstapayUtilites.TakeInput(Integer.class , "" ,"Invalid Id");
        Bill bill=billProvider.GetBill(billId);
        if(bill==null){
            System.out.println("Bill Not Found");
            return bill;
        }
        if(bill.isPaid()){
            System.out.println("Bill Already Paid");
            return null;
        }
        return bill;

    }

}
