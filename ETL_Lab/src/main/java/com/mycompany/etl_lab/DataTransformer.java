package com.mycompany.etl_lab;

import java.util.List;

public class DataTransformer {

    public List<List<String>> transformCustomers(List<List<String>> customers) {
        for (List<String> customer : customers) {
            customer.set(2, customer.get(2).toUpperCase()); // Convert Country to uppercase
        }
        return customers;
    }

    public List<List<String>> transformSales(List<List<String>> sales, List<List<String>> products) {
        for (List<String> sale : sales) {
            int productId = Integer.parseInt(sale.get(2)); // ProductID
            int quantity = Integer.parseInt(sale.get(3)); // Quantity
            for (List<String> product : products) {
                if (productId == Integer.parseInt(product.get(0))) {
                    double price = Double.parseDouble(product.get(2)); // Price
                    double totalPrice = quantity * price; // Calculate TotalPrice
                    sale.add(String.valueOf(totalPrice)); // Add TotalPrice to Sale data
                }
            }
        }
        return sales;
    }
}
