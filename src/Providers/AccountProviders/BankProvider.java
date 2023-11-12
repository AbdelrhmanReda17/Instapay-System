package Providers.AccountProviders;
import User.Account;
import java.util.Random;

public abstract class BankProvider implements IProvider {
    public static String generateOTP() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);
            otp.append(digit);
        }
        return otp.toString();
    }
    @Override
    public int Verify(String AccountId) {
        int OTP = Integer.parseInt(generateOTP());
        Account account = getAccount(AccountId);
        if(account != null){
            return OTP;
        }
        return -1;
    }
    @Override
    public void Update() {}
    abstract public Account getAccount(String AccountId);
    abstract public Account UpdateHandler();
}
