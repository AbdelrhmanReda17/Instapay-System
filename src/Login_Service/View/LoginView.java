package Login_Service.View;
import Istapay_interface.view.InstapayView;
import Main.InstapayUtilites;
public class LoginView {

    public static String[] LoginMenu(){
        while(true){
            Splitter();
            String[] data={"",""};
            System.out.print("Please enter your username - Exit to close : ");
            String username = Main.InstapayUtilites.TakeInput(String.class  , "" , "");
            if(username.equals("Exit")){
                return data;
            }
            System.out.print("Please enter your password - Exit to close : ");
            String password =Main.InstapayUtilites.TakeInput(String.class  , "" , "");
            if(password.equals("Exit")){
                return data;
            }
            data[0]=username;
            data[1]=password;
            return data;
        }
    }
    public static void Splitter() {
        System.out.println("----------------------------------");
    }

}
