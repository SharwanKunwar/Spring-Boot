package org.unpredictableXpractice.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRepository
{
    String url = "jdbc:postgresql://localhost:5432/jdbc_practice";
    String username = "postgres";
    String password = "9814631974";

    public void create()
    {
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO student (name, age) VALUES ('Sharwan Jung Kunwar', 22)";
            int result = statement.executeUpdate(query);

            if(result == 1){
                System.out.println("Student created successfully");
            }else {
                System.out.println("Failed to create student");
            }

            connection.close();

        }catch (SQLException e){
            System.out.println("Failed to connect to database");
            System.out.println("Coz : "+e.getMessage());
        }
    }
}
