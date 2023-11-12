package Controllers;

import Factories.ProviderFactory;
import Providers.AccountProviders.IProvider;
import User.Account;
import User.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataController {
    ProviderFactory providerFactory = new ProviderFactory();
    private final String AccountsFilePath = "src\\Database\\Accounts.csv";
    private String line = "";
    public void SaveData(User user) {
        try (FileWriter writer = new FileWriter(AccountsFilePath, true)) {
            writer.write("\n"+ user.getData());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public int getMaxID() {
        int maxID = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountsFilePath))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns.length != 5) continue;
                if(Integer.parseInt(columns[0]) > maxID) {
                    maxID = Integer.parseInt(columns[0]);
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return maxID;
    }
    public boolean UpdateUser(User updatedUser){
        try {
            File file = new File(AccountsFilePath);
            List<String> lines = new ArrayList<>();

            // Read all lines into memory
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.contains(String.valueOf(updatedUser.getUserID()))) {
                    lines.set(i, updatedUser.getData());
                    break;
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String line : lines) {
                    writer.write(line + System.lineSeparator());
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
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
                    return null;
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
        System.out.println("Invalid Credentials !");
        return null;
    }
}
