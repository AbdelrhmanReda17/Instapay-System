package Providers.AccountProviders.Banks;

import Providers.AccountProviders.BankProvider;
import Entities.User.Account;
import Entities.User.BankAccount;

import java.io.BufferedReader;
import java.io.FileReader;

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
                return new BankAccount(columns[0],Double.parseDouble(columns[2]), this , columns[3]);
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
    public void Update(String userID) {

    }
    // UPDATE (ACCOUNT) => T7OTO
    // DEPOSIT - AMOUUNT / WITHDRAW - AMOUNT
    @Override
    public void Deposit(Account account, double ammount) {
        //Deposit should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        double currentAmount = account.getAmount();
        account.setAmount(currentAmount + ammount);
        Update(account.getAccountId());
    }
    @Override
    public boolean Withdraw(Account account, double ammount) {
        //Withdraw should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        double currentAmount = account.getAmount();
        if (currentAmount >= ammount) {
            account.setAmount(currentAmount - ammount);
            Update(account.getAccountId());
            return true;
        } else {
            return false;

        }
    }
}
