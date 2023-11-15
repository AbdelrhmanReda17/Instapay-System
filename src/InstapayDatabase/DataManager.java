package InstapayDatabase;

import Providers.ProviderFactory;
import Providers.AccountProviders.IProvider;
import InstapayApplication.Entities.User.Account;
import InstapayApplication.Entities.User.User;
import java.io.*;
import java.util.AbstractMap;
import java.util.Map;

public class DataManager {
    ProviderFactory providerFactory = new ProviderFactory();
    private final String AccountsFilePath = "src\\InstapayDatabase\\Database\\Accounts.csv";
    private String line = "";
    public void SaveData(User user,IProvider provider) {
        try (FileWriter writer = new FileWriter(AccountsFilePath, true)) {
            writer.write("\n"+ user.getUserID()+","+user.getUsername()+","+user.getPassword()+","+
                    user.getAccount().getType()+"-"+provider.getName()+
                    ","+user.getAccount().getData());

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
    public boolean checkUsername(String username){
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountsFilePath))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns.length != 5) continue;
                if(columns[1].equals(username)) return true;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Map.Entry<User, IProvider> LoadUser(String username , String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountsFilePath))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns.length != 5) continue;
                if(!columns[1].equals(username)) continue;
                if(!columns[2].equals(password)) return null;
                String[] tokens = columns[3].split("-");
                IProvider provider = providerFactory.CreateProvider(tokens[0] , tokens[1]);
                Account account = provider.getAccount(columns[4]);
                if(account == null) continue;
                User user= new User(Integer.parseInt(columns[0]),columns[1],columns[2],account);
                return new AbstractMap.SimpleEntry<>(user,provider);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Map.Entry<User,IProvider> GetUserByID(String ID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountsFilePath))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns.length != 5) continue;
                if(!columns[0].equals(ID)) continue;
                String[] tokens = columns[3].split("-");
                IProvider provider = providerFactory.CreateProvider(tokens[0] , tokens[1]);
                Account account = provider.getAccount(columns[4]);
                if(account == null) continue;
                User user= new User(Integer.parseInt(columns[0]),columns[1],columns[2],account);
                return new AbstractMap.SimpleEntry<>(user,provider);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
