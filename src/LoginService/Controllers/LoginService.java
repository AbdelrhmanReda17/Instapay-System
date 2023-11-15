package LoginService.Controllers;
import Entities.User.Account;

import InstapayDatabase.DataManager;
import LoginService.Views.LoginView;
import Entities.User.User;
import Providers.AccountProviders.IProvider;

import java.util.AbstractMap;
import java.util.Map;

public class LoginService {
    public static Map.Entry<User, IProvider> Login() {
        DataManager accountsManger = new DataManager();
        String[] data = LoginView.LoginMenu(accountsManger);
        if(data != null) return accountsManger.LoadUser(data[0] , data[1]);
        return null;
    }
}
