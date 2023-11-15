package TransactionService;

import Providers.AccountProviders.IProvider;

public abstract class TransferMenuView {
    protected IProvider distUserProvider;
    abstract public String[] Display();
    public IProvider getDistUserProvider() {
        return distUserProvider;
    }
}
