package RegisterationService.Controllers;


import InstapayApplication.Entities.User.Account;
import Utilites.InstapayUtilites;
import InstapayDatabase.DataManager;
import Providers.AccountProviders.IProvider;
import RegisterationService.Views.RegisterView;
import InstapayApplication.Entities.User.User;

import java.util.Map;

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
            Map.Entry<Account, IProvider> userPair = RegistrationFactory.createRegistration(choice);
            if(userPair == null) continue;
            return Registration(userPair);
        }
    }
    public User Registration(Map.Entry<Account, IProvider>  userPair){
        user.setUserType(userPair.getKey());
        while (true){
            if(getUserDetails()){
                user.setUserID(accountsManger.getMaxID() + 1);
                accountsManger.SaveData(user , userPair.getValue());
                return user;
            }
            return null;
        }
    }
   public boolean getUserDetails(){
       while(true){
           String username= RegisterView.Takeusername();
           if(accountsManger.checkUsername(username)){
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
