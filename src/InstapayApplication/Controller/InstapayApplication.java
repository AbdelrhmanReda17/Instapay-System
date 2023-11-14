package InstapayApplication.Controller;

import Entities.User.User;
import InstapayApplication.Views.InstapayView;
import LoginService.Controllers.LoginService;
import RegisterationService.Controllers.RegistrationService;


public class InstapayApplication {
    public User user;
    public InstapayApplication() {
        user = new User();
    }
    public void Start() {
        InstapayView.DisplayStartMessage();
        while (true) {
            int choice = InstapayView.MainMenu();
            switch (choice) {
                case 1:
                    user = LoginService.Login();
                    if (user != null) {
                        MainMenuController.Display(user);
                    }
                    break;
                case 2:
                    RegistrationService register = new RegistrationService();
                    user = register.Register();
                    if (user != null) {
                        MainMenuController.Display(user);
                    }
                    break;
                case 0:
                    InstapayView.DisplayExitMessage();
                    return;
            }
        }
    }

}

