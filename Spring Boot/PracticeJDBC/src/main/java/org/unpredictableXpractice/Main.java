package org.unpredictableXpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
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

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement())
        {
            stmt.executeUpdate(sql);
            System.out.println("Student table created successfully!");
        }
    }
}
