package Factories;


import Providers.BillProviders.BillProvider;
import Providers.BillProviders.ElectricityProvider;
import Providers.BillProviders.GasProvider;
import Providers.BillProviders.WaterProvider;

public class BillProvidersFactory {

        public static BillProvider CreateBillProvider(String type){
            return switch (type) {
                case "Gas" -> new GasProvider();
                case "Water" -> new WaterProvider();
                case "Electricity" -> new ElectricityProvider();

                default -> null;
            };

        }

}
