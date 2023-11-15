package InstapayApplication.Entities.User.Factories;

import Providers.AccountProviders.IProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public abstract class AccountFactory {
    protected final Map<String , Function<Void, IProvider>> AccountProviders = new HashMap<>();
    public IProvider CreateProvider(String type){
        return AccountProviders.get(type).apply(null);
    }
    public Set<String> GetProviders(){
        return AccountProviders.keySet();
    }
}
