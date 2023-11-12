import Controllers.DataController;
import User.User;

public class Main {
    public static void main(String[] args) {
        InstapayFacade instapayFacade = new InstapayFacade();
        instapayFacade.StartApplication();
//        DataController data = new DataController();
//        User user = data.LoadUser("Abdelrhman Reda" , "123456");
//        System.out.println(user.getData());
//        user.setUsername("Yassin el gamed");
//        data.UpdateUser(user);
    }
}