package org.unpredictableXpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Main
{
    static void main(String[] args)
    {
        String url = "jdbc:postgresql://localhost:5432/jdbc_practice";
        String username = "postgres";
        String password = "9814631974";

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully");
            connection.close();
        }catch (SQLException e){
            System.out.println("Failed to connect to database");
            System.out.println("Coz : "+e.getMessage());
        }

    }
}
