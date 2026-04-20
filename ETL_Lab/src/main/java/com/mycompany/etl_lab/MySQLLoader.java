package com.mycompany.etl_lab;

import java.sql.*;
import java.util.List;

public class MySQLLoader {

    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/DataWarehouse", "root", "");
    }

    public void loadCustomers(List<List<String>> customers) {
        try (Connection conn = connect()) {
            String query = "INSERT INTO Customers (CustomerID, CustomerName, Country) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            for (List<String> customer : customers) {
                stmt.setInt(1, Integer.parseInt(customer.get(0)));
                stmt.setString(2, customer.get(1));
                stmt.setString(3, customer.get(2));
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadProducts(List<List<String>> products) {
        try (Connection conn = connect()) {
            String query = "INSERT INTO Products (ProductID, ProductName, Price) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            for (List<String> product : products) {
                stmt.setInt(1, Integer.parseInt(product.get(0)));
                stmt.setString(2, product.get(1));
                stmt.setDouble(3, Double.parseDouble(product.get(2)));
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadSales(List<List<String>> sales) {
        try (Connection conn = connect()) {
            String query = "INSERT INTO Sales (SaleID, CustomerID, ProductID, Quantity, Date, TotalPrice) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            for (List<String> sale : sales) {
                stmt.setInt(1, Integer.parseInt(sale.get(0)));
                stmt.setInt(2, Integer.parseInt(sale.get(1)));
                stmt.setInt(3, Integer.parseInt(sale.get(2)));
                stmt.setInt(4, Integer.parseInt(sale.get(3)));
                stmt.setString(5, sale.get(4)); // Date
                stmt.setDouble(6, Double.parseDouble(sale.get(5))); // TotalPrice from transformed data
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
