package FacadeCollection;


import java.util.Set;

import Factories.BankFactory;
import Providers.AccountProviders.IProvider;
import User.User;

public class RegistrationFacade {
    private User user;
    private IProvider provider;

    public User Register() {
        while(true) {
            FacadeSingleton.Splitter();
            System.out.println("1. Register by Bank Account ");
            System.out.println("2. Register by Wallet ");
            System.out.println("0. Exit ");
            System.out.print("Please select an option [0 - 2]: ");
            int choice = FacadeSingleton.TakeInput(Integer.class , "" );
            switch (choice) {
                case 1:
                    user = BankRegistration();
                    if(user != null) {
                        return user;
                    }
                    break;
                case 2:
                    user = WalletRegistration();
                    if(user != null) {
                        return user;
                    }
                    break;
                case 0:
                    return null;
                default:
                    System.out.print("Invalid input, please enter a number between 0 and 2 :");
                    break;
            }
        }
    }
    public User BankRegistration(){
        return getAndVerifyAccount();
    }

   public IProvider BankSelection(){
        BankFactory bankFactory = new BankFactory();
        Set<String> bankFactoryArray = bankFactory.GetBankProviders();
        while (true){
            System.out.println("Please Select your Bank : ");
            for (int i = 1; i < bankFactoryArray.size() + 1; i++){
                System.out.println(i + ". " + bankFactoryArray.toArray()[i - 1]);
            }
           System.out.println("0. Exit");
           System.out.print("Please select an option [0 - "+ bankFactoryArray.size() +"]: ");
           int choice = FacadeSingleton.TakeInput(Integer.class , "" );
            if (choice == 0) {
                return null;
            }
            else if (choice > 0 && choice <= bankFactoryArray.size()) {
                return bankFactory.CreateBank(bankFactoryArray.toArray()[choice - 1].toString());
            }
            else {
                System.out.print("Invalid input, please enter a number between [0 - "+ bankFactoryArray.size() +"]: ");
            }
       }
   }

   public User getAndVerifyAccount(){
       provider = BankSelection();
       if(provider == null){
           return null;
       }
       System.out.print("Please enter your Bank Account Number - Exit to close : ");
       String bankId = FacadeSingleton.TakeInput(String.class  , "" );
       int OTP =  provider.Verify(bankId);
       if(OTP == -1){
           return null;
       }
       System.out.println("23ml nfsk el OTP GALK W HOWA [ " + OTP + " ] ");
       System.out.print("Please enter the OTP sent to your mobile number : ");
       int userOTP = FacadeSingleton.TakeInput(Integer.class  , "" );
       int counter = 0;
       while (userOTP != OTP && counter < 3 ){
           System.out.print("OTP is incorrect , Please try again : ");
           userOTP = FacadeSingleton.TakeInput(Integer.class  , "" );
           counter++;
       }
       if(counter == 3 && userOTP != OTP){
           System.out.println("OTP is incorrect , Please try again later");
           return null;
       }
       System.out.println("Account Verified Successfully");
//        return provider.getAccount(bankId);
       return null;
   }

    public User WalletRegistration(){
        return new User();
    }
}
