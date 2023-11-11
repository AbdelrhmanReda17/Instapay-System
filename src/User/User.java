package User;
import java.util.Vector;
public class User {

    private Account userType;
    private String username;
    private String password;
    private int userID;
//    private Vector<Bill> Bills;

    public User(){
        userType = new WalletAccount("01000000000", 1000);
//        Bills = new Vector<Bill>();
        username = "Abdelrhman";
        password = "123456";
        userID = 1;
    }
//    public String getData(){
//        return userID + "," + username + "," + password + "," + UserType + "," + Bills;
//    }
//    public Vector<Bill> getBills() {
//        return Bills;
//    }

    public Account getAccount() {
        return userType;
    }


//    public void setBills(Vector<Bill> bills) {
//        Bills = bills;
//    }

}