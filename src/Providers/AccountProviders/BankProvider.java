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
            String phone = account.getPhoneNumber().substring(0, 2) + "*******" + account.getPhoneNumber().substring(7);
            System.out.println("An OTP has been sent to your phone number " + phone + " , please enter it to verify your account");
            // Send OTP to the user via SMS
            return OTP;
        }
        return -1;
    }
    @Override
    public void Update() {}
    abstract public Account getAccount(String AccountId);
    abstract public String getName();
    abstract public Account UpdateHandler();
}
