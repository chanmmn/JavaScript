package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        readActorTable();
    }

    public static void readActorTable() {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM actor")) {
            while (rs.next()) {
                int actorId = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                System.out.println("ID: " + actorId + ", First Name: " + firstName + ", Last Name: " + lastName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

