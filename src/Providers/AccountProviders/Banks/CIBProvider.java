package Providers.AccountProviders.Banks;

import InstapayApplication.Entities.User.Account;
import InstapayApplication.Entities.User.BankAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CIBProvider extends BankProvider {
    private final String AccountsFilePath = "src\\InstapayDatabase\\Database\\CIBAccounts.csv";

    @Override
    public Account getAccount(String AccountId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountsFilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns.length != 4) continue;
                if(!columns[0].equals(AccountId)) continue;
                return new BankAccount(columns[0], columns[1],Double.parseDouble(columns[2]) , columns[3]);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public String getName() {
        return "CIB";
    }

    @Override
    public boolean Update(Account account) {
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
                String[] tokens = line.split(",");
                if (tokens[0].equals(account.getAccountId()) && tokens[3].equals(account.getPhoneNumber())) {
                    lines.set(i , account.getAccountId() + "," + account.getPassword() + "," + account.getAmount() + "," + account.getPhoneNumber());
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
    // UPDATE (ACCOUNT) => T7OTO
    // DEPOSIT - AMOUUNT / WITHDRAW - AMOUNT
    @Override
    public void Deposit(Account account, double ammount) {
        //Deposit should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        double currentAmount = account.getAmount();
        account.setAmount(currentAmount + ammount);
        Update(account);
    }
    @Override
    public boolean Withdraw(Account account, double ammount) {
        //Withdraw should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        double currentAmount = account.getAmount();
        if (currentAmount >= ammount) {
            account.setAmount(currentAmount - ammount);
            Update(account);
            return true;
        }  else {
            System.out.println("Insufficient Funds!");
            return false;
        }
    }
}
