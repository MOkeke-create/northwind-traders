package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        String sql = """
                SELECT ProductId,
                       ProductName
                FROM products
                """;


        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()){
                int ProductId = resultSet.getInt("ProductId");
                String productName = resultSet.getString("ProductName");
                System.out.printf("%d %s", ProductId, productName);
            }
        } catch (SQLException e){
            System.out.println("Faied to retrieve products. Please try again.");
            e.printStackTrace();
        }
    }
}
