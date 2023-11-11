package FacadeCollection;

import User.User;

public class LoginFacade {
    public User Login() {
        while(true){
            FacadeSingleton.Splitter();
            System.out.print("Please enter your username - Exit to close : ");
            String username = FacadeSingleton.TakeInput(String.class  , "");
            if(username.equals("Exit")){
                return null;
            }
            System.out.print("Please enter your password - Exit to close : ");
            String password = FacadeSingleton.TakeInput(String.class  , "");
            if(password.equals("Exit")){
                return null;
            }
            // Login logic here ... (username , password) -> (user);
            // if login success return user else return null
            return new User();
        }
    }
}
