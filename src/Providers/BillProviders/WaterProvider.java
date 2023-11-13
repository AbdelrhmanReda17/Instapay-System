package Providers.BillProviders;

import Bills.Bill;
import Bills.GasBills;
import Bills.WaterBills;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WaterProvider implements BillProvider{
    String FilePath="src\\Database\\WaterBills.csv";


    @Override
    public Bill GetBill(int billId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                System.out.println(line);
                if(columns.length != 5) continue;
                if(Integer.parseInt(columns[0])!=billId)continue;

                return new WaterBills(Integer.parseInt(columns[0]),columns[1],Double.parseDouble(columns[2])
                        ,Boolean.parseBoolean(columns[4]),Double.parseDouble(columns[3]));
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    @Override
    public boolean PayBill(Bill updatedBill) {
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FilePath))) {
            updatedLines.add(reader.readLine());
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length != 5) {
                    updatedLines.add(line);
                    continue;
                }

                int billId = Integer.parseInt(columns[0]);

                if (billId == updatedBill.getBillId()) {
                    columns[4] = "true";
                }

                updatedLines.add(String.join(",", columns));
            }
        } catch (IOException e) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FilePath))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;

        }
    }

}
