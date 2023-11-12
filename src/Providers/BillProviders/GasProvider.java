package Providers.BillProviders;

import Bills.Bill;
import Bills.GasBill;

import java.io.BufferedReader;
import java.io.FileReader;

public class GasProvider implements BillProvider {
    private final String BillFilePath = "src\\Database\\GasBills.csv";
    @Override
    public Bill GetBill(int BillId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(BillFilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                System.out.println(columns.length);
                if(columns.length != 5) continue;
                if(Integer.parseInt(columns[0])!=BillId)continue;

                return new GasBill(Integer.parseInt(columns[0]),columns[1],Double.parseDouble(columns[2])
                        ,Boolean.parseBoolean(columns[3]),Double.parseDouble(columns[4]));
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean UpdateBill(Bill bill) {
        return false;
    }
}
