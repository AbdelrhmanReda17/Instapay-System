package RegisterationService.Controllers;


import Entities.User.Account;
import InstapayApplication.Utilites.InstapayUtilites;
import InstapayDatabase.DataManager;
import RegisterationService.Views.RegisterView;
import Entities.User.User;

public class RegistrationService {
    private User user;
    private final DataManager accountsManger;
    public RegistrationService(){
        user = new User();
        accountsManger = new DataManager();
    }
    public User Register() {
        while(true) {
            InstapayUtilites.Splitter();
            int choice = RegisterView.RegisterMenu();
            if(choice == 0) return null;
            Account account = RegistrationFactory.createRegistration(choice);
            if(account == null) continue;
            return Registration(account);
        }
    }
    public User Registration(Account Account){
        user.setUserType(Account);
        while (true){
            if(getUserDetails()){
                user.setUserID(accountsManger.getMaxID() + 1);
                accountsManger.SaveData(user);
                return user;
            }
            return null;
        }
    }
   public boolean getUserDetails(){
       while(true){
           String username= RegisterView.Takeusername();
           if(!accountsManger.checkUsername(username)){
               System.out.println("Username already exists , Please try again");
               continue;
           }
           if(username.equals("Exit")){
               return false;
           }
           String password= RegisterView.TakeuserDetails();
          if(password.equals("Exit")){
               return false;
           }
           user.setUsername(username);
           user.setPassword(password);
           return true;
       }
   }
}
