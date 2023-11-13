package Providers.AccountProviders.Banks;

import Providers.AccountProviders.BankProvider;
import User.Account;
import User.BankAccount;

import java.io.BufferedReader;
import java.io.FileReader;

public class CIBProvider extends BankProvider {
    private final String AccountsFilePath = "src\\Database\\CIBAccounts.csv";
    private final String Name = "CIB";
    @Override
    public Account getAccount(String AccountId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountsFilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns.length != 4) continue;
                if(!columns[0].equals(AccountId)) continue;
                return new BankAccount(columns[0],columns[1],Double.parseDouble(columns[2]) , this , columns[3]);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String getName() {
        return Name;
    }

    @Override
    public Account UpdateHandler() {
        return null;
    }
}
