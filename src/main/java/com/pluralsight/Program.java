package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

public class Program {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("");

    }
}
