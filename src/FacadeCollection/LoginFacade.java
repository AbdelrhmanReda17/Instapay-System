package FacadeCollection;

import Controllers.DataController;
import User.User;

public class LoginFacade {
    DataController dataController = new DataController();
    public User Login() {
        while(true){
            FacadeSingleton.Splitter();
            System.out.print("Please enter your username - Exit to close : ");
            String username = FacadeSingleton.TakeInput(String.class  , "" , "");
            if(username.equals("Exit")){
                return null;
            }
            System.out.print("Please enter your password - Exit to close : ");
            String password = FacadeSingleton.TakeInput(String.class  , "" , "");
            if(password.equals("Exit")){
                return null;
            }
            return dataController.LoadUser(username , password);
        }
    }
}
