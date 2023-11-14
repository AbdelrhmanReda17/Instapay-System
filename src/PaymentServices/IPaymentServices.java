package PaymentServices;

import Entities.User.Account;
import Providers.AccountProviders.IProvider;

public interface IPaymentServices {
    void Pay(Account account, IProvider provider);
}
