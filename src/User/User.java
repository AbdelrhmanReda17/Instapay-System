package User;
public class User {

    private Account userType;
    private String username;
    private String password;
    private int userID;
    public User() {}
    public String getUsername() {
        return username;
    }
    public int getUserID() {
        return userID;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public User(int userID, String username, String password, Account userType) {
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.userType = userType;
    }
    public String getData(){
        return userID + "," + username + "," + password + "," + userType.getData();
    }

    public Account getAccount() {
        return userType;
    }

}