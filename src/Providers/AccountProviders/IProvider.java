package Providers.AccountProviders;

import InstapayApplication.Entities.User.Account;

import java.util.Random;

public abstract class IProvider {
    public abstract int Verify(String data);
    public abstract boolean Update(Account account);
    public abstract String getName();
    public abstract Account getAccount(String token);
    public String generateOTP() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);
            otp.append(digit);
        }
        return otp.toString();
    }

    public abstract void Deposit(Account account, double ammount);
    public abstract boolean Withdraw(Account account, double ammount);
}