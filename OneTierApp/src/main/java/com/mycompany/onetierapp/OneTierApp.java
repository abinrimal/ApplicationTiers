package com.mycompany.onetierapp;

import java.util.ArrayList;
import java.util.Scanner;

public class OneTierApp {
    private static ArrayList<String> customers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Enter customer name (or type 'exit' to quit): ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("exit")) {
                customers.add(input);
                System.out.println("Customer added: " + input);
            }
        } while (!input.equalsIgnoreCase("exit"));

        System.out.println("Stored Customers: " + customers);
        scanner.close();
    }
}
