package Registeration_service.controller;


import java.util.Set;

import Model.AccountsManger;
import Registeration_service.Factories.BankFactory;
import Registeration_service.view.registerView;
import Providers.AccountProviders.IProvider;
import User.model.User;

public class Registration_service {
    private User user;

    private final AccountsManger accountsManger;
    public Registration_service(){
        user = new User();
        accountsManger = new AccountsManger();
    }
    public User Register() {
        while(true) {
            Main.InstapayUtilites.Splitter();
            int choice = registerView.RegisterMenu();
            switch (choice) {
                case 1:
                    user = BankRegistration();
                    return  user;
                case 2:
                    user = WalletRegistration();
                    if(user != null) {
                        return user;
                    }
                    break;
                case 0:
                    return null;
                default:
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
           int choice = registerView.BanksMenu(bankFactoryArray);
            if (choice == 0) {
                return null;
            }
            return bankFactory.CreateBank(bankFactoryArray.toArray()[choice - 1].toString());
    }

   public User getAndVerifyAccount(){
        while(true) {
            IProvider provider = BankSelection();
            if(provider == null){
                return null;
            }
            System.out.print("Please enter your Bank Account Number - Exit to close : ");
            String bankId =Main.InstapayUtilites.TakeInput(String.class , "" , "" );
            int OTP =  provider.Verify(bankId);
            if(OTP == -1){
                System.out.println("Invalid Account Number , Please try again");
                continue;
            }
            user.setUserType(provider.getAccount(bankId));
           if(registerView.VerfiyView(1234,1)){
                if(getUserDetails()){
                    user.setUserID(accountsManger.getMaxID() + 1);
                    accountsManger.SaveData(user);
                    return user;
                }else {
                    return null;
                }
           }
        }
   }
   public boolean getUserDetails(){
       while(true){
           String username=registerView.Takeusername();
           if(!accountsManger.checkUsername(username)){
               System.out.println("Username already exists , Please try again");
               continue;
           }
           if(username.equals("Exit")){
               return false;
           }
           String password=registerView.TakeuserDetails();
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
