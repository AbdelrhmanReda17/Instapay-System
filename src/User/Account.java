package User;

public abstract class Account {
    private double amount;
    private final String providerName;
    private final String phoneNumber;
    
    public Account(double amount , String ProviderName , String phoneNumber) {
        this.amount = amount;
        this.providerName = ProviderName;
        this.phoneNumber = phoneNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void Deposit(double amount) {
        this.amount += amount;
    }
    public boolean Withdraw(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return true;
        }
        else {
            return false;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public double getAmount() {
        return amount;
    }
    abstract public String getData();
}
