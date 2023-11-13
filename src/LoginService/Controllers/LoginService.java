package LoginService.Controllers;

import InstapayDatabase.DataManager;
import LoginService.Views.LoginView;
import Entities.User.User;

public class LoginService {
    public static User Login() {
        DataManager accountsManger = new DataManager();
        String[] data = LoginView.LoginMenu();
        if(data != null) return accountsManger.LoadUser(data[0] , data[1]);
        return null;
    }
}
