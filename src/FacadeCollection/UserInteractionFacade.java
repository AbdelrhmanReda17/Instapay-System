package FacadeCollection;


import User.User;

public class UserInteractionFacade {
    private User user;
    public User MainMenu() {
        while(true){
            FacadeSingleton.DisplayStartMessage();
            System.out.println("1. Login with existing account");
            System.out.println("2. Register new account");
            System.out.println("0. Exit");
            System.out.print("Please select an option [0 - 2]: ");
            int choice = FacadeSingleton.TakeInput(Integer.class , "");
            switch (choice) {
                case 1:
                    LoginFacade loginFacade = new LoginFacade();
                    user = loginFacade.Login();
                    if(user != null) {
                        return user;
                    }
                    break;
                case 2:
                    RegistrationFacade registrationFacade = new RegistrationFacade();
                    user = registrationFacade.Register();
                    if(user != null) {
                        return user;
                    }
                    break;
                case 0:
                    FacadeSingleton.DisplayExitMessage();
                    return null;
                default:
                    System.out.println("Invalid input, please enter a number between 0 and 2.");
                    break;
            }
        }
    }
}
