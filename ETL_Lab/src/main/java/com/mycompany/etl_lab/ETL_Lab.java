package com.mycompany.etl_lab;

import java.util.List;

public class ETL_Lab {

    public static void main(String[] args) {
        // Parse XML data
        XMLParser parser = new XMLParser();
        List<List<String>> customers = parser.parseCustomers("Customers.xml");
        List<List<String>> products = parser.parseProducts("Products.xml");
        List<List<String>> sales = parser.parseSales("Sales.xml");

        // Transform data
        DataTransformer transformer = new DataTransformer();
        customers = transformer.transformCustomers(customers);
        sales = transformer.transformSales(sales, products);

        // Load data into MySQL
        MySQLLoader loader = new MySQLLoader();
        loader.loadCustomers(customers);
        loader.loadProducts(products);
        loader.loadSales(sales);

        // Run data analysis
        DataAnalysis analysis = new DataAnalysis();
        analysis.runAnalysis();
    }
}
