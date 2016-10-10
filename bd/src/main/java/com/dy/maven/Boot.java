package com.dy.maven;

import org.h2.Driver;

import java.sql.*;

public class Boot {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new Driver());
        Connection c = DriverManager.getConnection("jdbc:h2:~/base");
        displayUsersAndTheirRoles(c);
        displayChangeLogs(c);
        c.close();
    }

    private static void displayChangeLogs(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("SELECT * FROM databasechangelog");
        ResultSet rs = ps.executeQuery();
        System.out.println("------- DATABASE CHANGE LOGS --------");
        while (rs.next()) {
            System.out.println("");
            System.out.println("id: " + rs.getString("id"));
            System.out.println("author: " + rs.getString("author"));
            System.out.println("filename: " + rs.getString("filename"));
            System.out.println("description: " + rs.getString("description"));
            System.out.println("comments: " + rs.getString("comments"));
        }
        System.out.println("-------------------------------------");
    }

    private static void displayUsersAndTheirRoles(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("SELECT * FROM user");
        ResultSet rs = ps.executeQuery();
        System.out.println("--------- USERS AND ROLES ----------");
        while (rs.next()) {
            System.out.println("");
            System.out.println("username: " + rs.getString("username"));
            System.out.println("password: " + rs.getString("password"));
            System.out.println("enabled: " + rs.getBoolean("enabled"));
            System.out.println("roles: " + getRolesOfUser(rs.getString("username"), c));
        }
        System.out.println("-------------------------------------");
    }

    public static String getRolesOfUser(String username, Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("SELECT role FROM role WHERE username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        StringBuilder sb = new StringBuilder("[");
        while (rs.next()) {
            sb.append(rs.getString("role"));
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
