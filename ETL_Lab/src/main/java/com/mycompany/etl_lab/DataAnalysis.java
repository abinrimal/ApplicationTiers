package com.mycompany.etl_lab;

import java.sql.*;

public class DataAnalysis {

    public void runAnalysis() {
        String query = "SELECT SUM(TotalPrice) AS TotalRevenue, ProductName FROM Sales "
                     + "INNER JOIN Products ON Sales.ProductID = Products.ProductID "
                     + "GROUP BY ProductName";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DataWarehouse", "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                double totalRevenue = rs.getDouble("TotalRevenue");
                String productName = rs.getString("ProductName");
                System.out.println("Product: " + productName + ", Total Revenue: " + totalRevenue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
