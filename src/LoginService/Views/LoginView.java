package LoginService.Views;
import Utilites.InstapayUtilites;
import InstapayDatabase.DataManager;

public class LoginView {
    public static String[] LoginMenu(DataManager dataManager){
        InstapayUtilites.Splitter();
        while (true){
            String[] data= {"",""} ;
            System.out.print("Please enter your username - Exit to close: ");
            data[0] = InstapayUtilites.TakeInput(String.class  , "^[a-zA-Z0-9_\\.]{3,20}$" , "Username must be between 3 and 20 characters long and can only contain letters, numbers, underscores and dots: " );
            if(data[0].equals("Exit") ) return null;
            if(!dataManager.checkUsername(data[0])) {
                System.out.print("Username not found!, ");
                continue;
            }
            System.out.print("Please enter your password - Exit to close : ");
            data[1] = InstapayUtilites.TakeInput(String.class  , "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$" , "Password must be at least 8 characters long and contain at least one lowercase letter, one uppercase letter, one digit and one special character: " );
            if(data[1].equals("Exit")){
                return null;
            }
            return data;
        }
    }
    public static void LoginError(){
        System.out.println("Invalid username or password");
    }
    public static void LoginSuccess(){
        System.out.println("Login Successfully");
        InstapayUtilites.Splitter();
    }
}
