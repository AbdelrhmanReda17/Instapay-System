package Controllers;

import Factories.AccountFactory;
import Factories.ProviderFactory;
import Providers.IProvider;
import User.Account;
import User.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataController {
    ProviderFactory providerFactory = new ProviderFactory();
    private final String AccountsFilePath = "src\\Database\\Accounts.csv";
    private String line = "";
    public void SaveData() {
        //System.out.println("Data saved successfully");
    }
    public User LoadUser(String username , String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountsFilePath))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns.length != 5) continue;
                if(!columns[1].equals(username)) continue;
                if(!columns[2].equals(password)) {
                    System.out.println("Invalid Password , Please try again !");
                    break;
                }
                String[] tokens = columns[3].split("-");
                IProvider provider = providerFactory.CreateProvider(tokens[0] , tokens[1]);
                Account account = provider.getAccount(columns[4]);
                if(account == null) continue;
                return new User(Integer.parseInt(columns[0]),columns[1],columns[2],account);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
