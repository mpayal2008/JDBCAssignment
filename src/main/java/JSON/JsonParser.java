package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;

import java.io.File;
import java.io.IOException;

public class JsonParser {
    public static void main(String[] args) throws IOException {
        File jsonFile = new File("src/main/resources/json2.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file into an object
            ComputerData computerData = objectMapper.readValue(jsonFile, ComputerData.class);

            // Access the parsed data
            ComputersTable computersTable = computerData.getDataTable().getComputersTable();
            for (Computers computer : computersTable.getComputers()) {
                System.out.println("Computer ID: " + computer.getComputer_id());
                System.out.println("Internal Config ID: " +computer.getInternal_config_id());
                System.out.println("Brand Name: " + computer.getBrand_name());
                System.out.println("Model Name: " +computer.getModel_name() );

            }

            CustomerTable customerTable = computerData.getDataTable().getCustomerTable();
            for (Customer customer : customerTable.getCustomers()) {
                System.out.println("Customer ID: " +customer.getCustomer_id());
                System.out.println("Username: " + customer.getUsername());
                System.out.println("Password: " + customer.getPassword());
                System.out.println("Full Name: " + customer.getFull_name());
                System.out.println("Email: " + customer.getEmail());
                System.out.println();
            }

            OrderData orderData = computerData.getDataTable().getOrderDataTable().getOrderData();
            System.out.println("Order ID: " + orderData.getOrder_id());
            System.out.println("Computer ID: " + orderData.getComputer_id());
            System.out.println("Order Date: " + orderData.getOrder_date());
            System.out.println("Order Detail: " + orderData.getOrder_detail());
            System.out.println("Customer ID: " + orderData.getCustomer_id());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

