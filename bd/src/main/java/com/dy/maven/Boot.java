package com.dy.maven;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Boot {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new Driver());
        Connection c = DriverManager.getConnection("jdbc:h2:~/base");
        PreparedStatement ps = c.prepareStatement("SELECT * FROM customer");
        ResultSet rs = ps.executeQuery();
        System.out.println("------- CUSTOMERS --------");
        while (rs.next()) {
            System.out.println("----------");
            System.out.println("ID: " + rs.getLong("id"));
            System.out.println("Balance: " + rs.getInt("balance"));
        }
        System.out.println("--------------------------");
        c.close();
    }
}
