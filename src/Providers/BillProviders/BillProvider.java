package Providers.BillProviders;

import Bills.Bill;
import Bills.ElectricityBills;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public  class BillProvider {
    protected  String FilePath;
    public  Bill GetBill(int BillId){
        try (BufferedReader reader = new BufferedReader(new FileReader(FilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                System.out.println(columns.length);
                if(columns.length != 5) continue;
                if(Integer.parseInt(columns[0])!=BillId)continue;

                return new ElectricityBills(Integer.parseInt(columns[0]),columns[1],Double.parseDouble(columns[2])
                        ,Boolean.parseBoolean(columns[3]),Double.parseDouble(columns[4]));
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    };

    public  boolean UpdateBill(Bill updatedBill){
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FilePath))) {
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
    };
}
