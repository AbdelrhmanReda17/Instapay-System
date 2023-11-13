package Entities.User;

import Transaction_Service.view.TransactionMenu;

public class User {
    private Account userType;
    private String username;
    private String password;
    private int userID;

    private TransactionMenu menu;
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserType(Account userType) {
        this.userType = userType;
    }

    public int UserMenu(){
       return menu.ViewMenu();
    }
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
    public User(int userID, String username, String password, Account userType, TransactionMenu menu) {
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.userType = userType;
        this.menu=menu;
    }
    public String getData(){
        return userID + "," + username + "," + password + "," + userType.getData();
    }

    public Account getAccount() {
        return userType;
    }

}