package org.unpredictableXpractice.repository;

import org.unpredictableXpractice.model.Student;

import java.sql.*;
import java.util.UUID;

public class StudentRepository
{
    String url = "jdbc:postgresql://localhost:5432/jdbc_practice";
    String username = "postgres";
    String password = "9814631974";

    public void create()
    {
        try(){
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();


            String query = "INSERT INTO student (name, age) VALUES ('Sharwan Jung Kunwar', 22)";
            int result = statement.executeUpdate(query);


            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Sharwan Jung Kunwar");
            preparedStatement.setInt(2, 22);

            preparedStatement.executeUpdate();

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

    public void getStudentById()
    {
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT id, name, age FROM student";

            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Student student = mapRow(resultSet);
            System.out.println(student);



            connection.close();

        }catch (SQLException e){
            System.out.println("Failed to connect to database");
            System.out.println("Coz : "+e.getMessage());
        }
    }

    private Student mapRow(ResultSet resultSet) throws SQLException
    {
        Student student = new Student("sharwan", 22);

        student.setId(resultSet.getObject("id", UUID.class));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));

        return student;
    }


}
