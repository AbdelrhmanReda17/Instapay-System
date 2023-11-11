package User;
import java.util.Vector;
import Bills.Bill;
public class User {

    private Account UserType;
    private String username;
    private String password;
    private int userID;
//    private Vector<Bill> Bills;

    public User(){
        UserType = new WalletAccount("01000000000", 1000);
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

    public Account getUserType() {
        return UserType;
    }

//    public void setBills(Vector<Bill> bills) {
//        Bills = bills;
//    }

}