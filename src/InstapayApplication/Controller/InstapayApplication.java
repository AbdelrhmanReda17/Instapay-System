package InstapayApplication.Controller;

import Entities.User.User;
import InstapayApplication.Utilites.InstapayUtilites;
import InstapayApplication.Views.InstapayView;
import LoginService.Controllers.LoginService;
import LoginService.Views.LoginView;
import Providers.AccountProviders.IProvider;
import RegisterationService.Controllers.RegistrationService;
import RegisterationService.Views.RegisterView;

import java.util.Map;


public class InstapayApplication {
    public User user;
    public IProvider provider;
    public InstapayApplication() {
        user = new User();
    }
    public void Start() {
        InstapayView.DisplayStartMessage();
        while (true) {
            int choice = InstapayView.MainMenu();
            switch (choice) {
                case 1:
                    Map.Entry<User, IProvider> data = LoginService.Login();
                    if(data != null){
                        LoginView.LoginSuccess();
                        user= data.getKey();
                        provider= data.getValue();
                        MainMenuController.Display(user,provider);
                        break;
                    }
                    LoginView.LoginError();
                    break;
                case 2:
                    RegistrationService register = new RegistrationService();
                    user = register.Register();
                    if (user != null) {
                        RegisterView.completeRegister();
                        break;
                    }
                    RegisterView.failedRegister();
                    break;
                case 0:
                    InstapayView.DisplayExitMessage();
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

}

