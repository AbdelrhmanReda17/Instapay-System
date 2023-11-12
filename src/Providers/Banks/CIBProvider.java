package Providers.Banks;

import Providers.BankProvider;
import User.Account;
import User.BankAccount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CIBProvider extends BankProvider {
    private final String AccountsFilePath = "src\\Database\\CIBAccounts.csv";

    @Override
    public Account getAccount(String AccountId) {
        System.out.println("CIB");
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountsFilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                System.out.println(columns.length);
                if(columns.length != 3) continue;
                return new BankAccount(columns[0],columns[1] ,Double.parseDouble(columns[2]));
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public Account UpdateHandler() {
        return null;
    }
}
