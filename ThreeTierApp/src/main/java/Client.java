import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("Enter customer name (or type 'exit' to quit): ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("exit")) {
                try {
                    URL url = new URL("http://localhost:8080/TwoTierApp/AddCustomerServlet?name=" + input);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    int responseCode = conn.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        System.out.println("Customer added: " + input);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } while (!input.equalsIgnoreCase("exit"));

        scanner.close();
    }
}
