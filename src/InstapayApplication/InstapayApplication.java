package InstapayApplication;

import Entities.User.User;
import InstapayApplication.Views.InstapayView;
import LoginService.Controllers.LoginService;
import RegisterationService.Controllers.RegistrationService;
import Transaction_Service.Controllers.TranscationService;
import Transaction_Service.Controllers.TransferController;

public class InstapayApplication {
    public User user;
    public TransferController transferController;
    public InstapayApplication() {
        user = new User();
    }
    public void Start() {
            StartApplication();
    }
    public void StartApplication () {
        InstapayView.DisplayStartMessage();
        while (true) {
            int choice = InstapayView.MainMenu();
            switch (choice) {
                case 1:
                    user = LoginService.Login();
                    if (user != null) {
                        System.out.println("You have successfully logged in");
                        TranscationService transaService = new TranscationService(user);
                        //trans.TranscationMenu();
                    }
                    break;
                case 2:
                    RegistrationService register = new RegistrationService();
                    user = register.Register();
                    if (user != null) {
                        System.out.println("You have successfully registered");
                        TranscationService transaService = new TranscationService(user);
                        //trans.TranscationMenu();
                    }
                    break;
                case 0:
                    InstapayView.DisplayExitMessage();
                    return;
            }
        }
    }
}
