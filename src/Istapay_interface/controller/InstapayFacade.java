package Istapay_interface.controller;

import Transaction_Service.Controllers.Transcation_Service;
import Transaction_Service.Controllers.TransferController;
import Istapay_interface.view.InstapayView;
import Login_Service.Controller.LogService;
import Registeration_service.controller.Registration_service;
import User.model.User;

public class InstapayFacade {

    public User user;
    public TransferController transferController;
    public InstapayFacade() {
        user = new User();
    }
    public void StartApplication () {
        InstapayView.DisplayStartMessage();
        boolean working = true;
        while (working) {
            int choice = InstapayView.MainMenu();
            switch (choice) {
                case 1:
                    LogService login = new LogService();
                    user = login.Login();
                    if (user != null) {
                        Transcation_Service trans= new Transcation_Service(user);
                    }
                    break;
                case 2:
                    Registration_service register = new Registration_service();
                    user = register.Register();
                    if (user != null) {
                        Transcation_Service trans= new Transcation_Service(user);
                    }
                    break;
                case 0:
                    InstapayView.DisplayExitMessage();
                    working = false;
                default:
                    break;
            }
        }
    }



}
