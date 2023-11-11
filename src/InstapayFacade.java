import FacadeCollection.FacadeSingleton;
import FacadeCollection.UserInteractionFacade;
import User.User;

public class InstapayFacade {
    public UserInteractionFacade userInteractionFacade;
    public User user;
    public InstapayFacade() {
        user = new User();
        userInteractionFacade = new UserInteractionFacade();
    }
    void StartApplication () {
        user = userInteractionFacade.MainMenu();
        if(user == null){
            FacadeSingleton.DisplayExitMessage();
            return;
        }
        StartMenu();
    }

    void StartMenu() {
        System.out.println("1. Transfer to Wallet using the mobile number");
        System.out.println("2. Transfer to Another instapay account");
        System.out.println("3. Inquire about his balance");
        System.out.println("4. Pay Bill");
        System.out.println("0. Log out");
        System.out.print("Please select an option [0 - 4]: ");
    }
}
