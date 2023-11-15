package Providers.Factories;



import Providers.BillProviders.BillProvider;
import Providers.BillProviders.ElectricityProvider;
import Providers.BillProviders.GasProvider;
import Providers.BillProviders.WaterProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class BillProvidersFactory {
    private static Map<String , Function<Void, BillProvider>> BillProviders = new HashMap<>();
    public BillProvidersFactory() {
        BillProviders.put("Gas",billProvider->{
            return new GasProvider();
        });

        BillProviders.put("Electricity",billProvider->{
            return new ElectricityProvider();
        });
        BillProviders.put("Water",billProvider->{
            return new WaterProvider();
        });

    }

    public static   BillProvider CreateBillProvider(String type){
        return BillProviders.get(type).apply(null);
    }
    public Set<String> GetBillProviders() {
        return BillProviders.keySet();
    }

}
