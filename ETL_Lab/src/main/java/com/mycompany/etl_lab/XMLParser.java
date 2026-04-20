package com.mycompany.etl_lab;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    public List<List<String>> parseCustomers(String filePath) {
        List<List<String>> customers = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));

            NodeList customerList = doc.getElementsByTagName("Customer");
            for (int i = 0; i < customerList.getLength(); i++) {
                Element customerElement = (Element) customerList.item(i);
                List<String> customerData = new ArrayList<>();
                customerData.add(customerElement.getElementsByTagName("CustomerID").item(0).getTextContent());
                customerData.add(customerElement.getElementsByTagName("CustomerName").item(0).getTextContent());
                customerData.add(customerElement.getElementsByTagName("Country").item(0).getTextContent());
                customers.add(customerData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<List<String>> parseProducts(String filePath) {
        List<List<String>> products = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));

            NodeList productList = doc.getElementsByTagName("Product");
            for (int i = 0; i < productList.getLength(); i++) {
                Element productElement = (Element) productList.item(i);
                List<String> productData = new ArrayList<>();
                productData.add(productElement.getElementsByTagName("ProductID").item(0).getTextContent());
                productData.add(productElement.getElementsByTagName("ProductName").item(0).getTextContent());
                productData.add(productElement.getElementsByTagName("Price").item(0).getTextContent());
                products.add(productData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<List<String>> parseSales(String filePath) {
        List<List<String>> sales = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));

            NodeList saleList = doc.getElementsByTagName("Sale");
            for (int i = 0; i < saleList.getLength(); i++) {
                Element saleElement = (Element) saleList.item(i);
                List<String> saleData = new ArrayList<>();
                saleData.add(saleElement.getElementsByTagName("SaleID").item(0).getTextContent());
                saleData.add(saleElement.getElementsByTagName("CustomerID").item(0).getTextContent());
                saleData.add(saleElement.getElementsByTagName("ProductID").item(0).getTextContent());
                saleData.add(saleElement.getElementsByTagName("Quantity").item(0).getTextContent());
                saleData.add(saleElement.getElementsByTagName("Date").item(0).getTextContent());
                sales.add(saleData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sales;
    }
}
