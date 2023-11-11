package FacadeCollection;


import User.User;

public class RegistrationFacade {
    private User user;
    public User Register() {
        while(true) {
            FacadeSingleton.Splitter();
            System.out.println("1. Register by Bank Account ");
            System.out.println("2. Register by Wallet ");
            System.out.println("0. Exit ");
            System.out.print("Please select an option [0 - 2]: ");
            int choice = FacadeSingleton.TakeInput(Integer.class , "");
            switch (choice) {
                case 1:
                    System.out.println("Register by Bank Account");
                    user = BankRegistration();
                    if(user != null) {
                        return user;
                    }
                    break;
                case 2:
                    System.out.println("Register by Wallet");
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
        return new User();
    }
    public User WalletRegistration(){
        return new User();
    }
}
