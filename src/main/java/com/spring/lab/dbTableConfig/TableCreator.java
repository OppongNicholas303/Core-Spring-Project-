package com.spring.lab.dbTableConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableCreator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/shop";
        String user = "root";
        String password = "NicTech23";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String createCustomerTable = """
                CREATE TABLE IF NOT EXISTS customer (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    email VARCHAR(100) NOT NULL UNIQUE
                )
            """;

            String createProductTable = """
                CREATE TABLE IF NOT EXISTS product (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    price DECIMAL(10, 2) NOT NULL
                )
            """;

            String createOrderTable = """
                CREATE TABLE IF NOT EXISTS `order` (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    customer_id INT NOT NULL,
                    product_id INT NOT NULL,
                    quantity INT NOT NULL,
                    total_price DECIMAL(10, 2) NOT NULL,
                    FOREIGN KEY (customer_id) REFERENCES customer(id),
                    FOREIGN KEY (product_id) REFERENCES product(id)
                )
            """;

            statement.execute(createCustomerTable);
            statement.execute(createProductTable);
            statement.execute(createOrderTable);

            System.out.println("Tables created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
