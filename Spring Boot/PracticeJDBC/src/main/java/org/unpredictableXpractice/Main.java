package org.unpredictableXpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Main
{
    static void main(String[] args) throws SQLException
    {
        String url = "jdbc:postgresql://localhost:5432/jdbc_practice";
        String username = "postgres";
        String password = "9814631974";

        String sql = """
            CREATE TABLE IF NOT EXISTS student (
                id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                name VARCHAR(255),
                age INT
            )
            """;

        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully");
            conn.close();
        }catch (Exception e){
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }
}
