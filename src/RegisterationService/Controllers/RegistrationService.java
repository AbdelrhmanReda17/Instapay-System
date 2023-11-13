package RegisterationService.Controllers;


import java.util.Set;

import InstapayApplication.Utilites.InstapayUtilites;
import InstapayDatabase.DataManager;
import Entities.User.Factories.BankFactory;
import RegisterationService.Views.RegisterView;
import Providers.AccountProviders.IProvider;
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
            switch (choice) {
                case 1:
                    user = BankRegistration();
                    if(user != null) return user;
                    break;
                case 2:
                    user = WalletRegistration();
                    if(user != null) return user;
                    break;
                case 0:
                    return null;
                default:
                    break;
            }
        }
    }
    public User BankRegistration(){
        while (true){
            IProvider provider = BankSelection();
            if(provider == null) return null;
            String bankId = Authentication.Verify(provider);
            if(bankId == null) continue;
            user.setUserType(provider.getAccount(bankId));
            if(getUserDetails()){
                user.setUserID(accountsManger.getMaxID() + 1);
                accountsManger.SaveData(user);
                return user;
            }
            return null;
        }
    }
   public IProvider BankSelection(){
        BankFactory bankFactory = new BankFactory();
        Set<String> bankFactoryArray = bankFactory.GetBankProviders();
           int choice = RegisterView.BanksMenu(bankFactoryArray);
            if (choice == 0) {
                return null;
            }
            return bankFactory.CreateBank(bankFactoryArray.toArray()[choice - 1].toString());
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
    public User WalletRegistration(){
        return new User();
    }
}
