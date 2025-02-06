package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class ETLPipeline {
    public static void main(String[] args) {
        String inputFile = "data/products.csv";
        String outputFile = "data/transformed_products.csv";
        try {
            List<String[]> transformedData = transform(inputFile);
            save(outputFile, transformedData);
            printData(transformedData);
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
    private static List<String[]> transform(String filePath) throws IOException {
        List<String[]> transformedData = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        
        String header = br.readLine(); 
        transformedData.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"});
        
        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields.length < 4) continue;

            int productId = Integer.parseInt(fields[0].trim());
            String name = capitalizeWords(fields[1].trim());
            double price = Double.parseDouble(fields[2].trim());
            String category = fields[3].trim();

            if (category.equalsIgnoreCase("Electronics")) {
                price = Math.round(price * 0.9 * 100.0) / 100.0;
                if (price > 500) category = "Premium Electronics";
            }

            String priceRange = getPriceRange(price);
            transformedData.add(new String[]{String.valueOf(productId), name, String.format("%.2f", price), category, priceRange});
        }
        br.close();
        return transformedData;
    }

    private static void save(String filePath, List<String[]> data) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        for (String[] row : data) {
            bw.write(String.join(",", row));
            bw.newLine();
        }
        bw.close();
        System.out.println("\nTransformed data saved to: " + filePath);
    }

    private static void printData(List<String[]> data) {
        System.out.println("\nTransformed Data:");
        for (String[] row : data) {
            System.out.println(String.join(",", row));
        }
    }

    private static String getPriceRange(double price) {
        if (price <= 10) return "Low";
        if (price <= 100) return "Medium";
        if (price <= 500) return "High";
        return "Premium";
    }

    private static String capitalizeWords(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
