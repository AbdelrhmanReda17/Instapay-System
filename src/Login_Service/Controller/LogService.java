package Login_Service.Controller;

import Model.AccountsManger;
import Login_Service.View.LoginView;
import User.model.User;

public class LogService {
  private AccountsManger accountsManger = new AccountsManger();
    public User Login() {
        String[] data=LoginView.LoginMenu();
        if(!data[0].equals("")&&!data[1].equals("")) {
            return accountsManger.LoadUser(data[0] , data[1]);
        }
        return null;
    }
}
