package com.student.dao;

import com.student.exception.InvalidInputException;
import com.student.util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class StudentDAO {
    public void getAllStudents() {
        String query = "SELECT * FROM students";

        try (
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String course = resultSet.getString("course");

                System.out.println(id + " | " + name + " | " + email + " | " + course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getStudentById(int studentId) {
        String query = "SELECT * FROM students WHERE id = ?";

        try(
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
                )
        {
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String course = resultSet.getString("course");

                System.out.println(id + " | " + name + " | " + email + " | " + course);
            }
            else {
                System.out.println("No student found with ID: " + studentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String name, String email, String course) throws InvalidInputException {
        validateStudentInput(name, email, course);
        String query = "INSERT INTO students(name, email, course) VALUES(?, ? ,?)";

        try(
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                )
        {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, course);

            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected>0){
                System.out.println("Student added successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudentCourse(int studentId, String newCourse) {
        String query = "UPDATE students SET course = ? WHERE id = ?";

        try(
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                )
        {
            preparedStatement.setString(1, newCourse);
            preparedStatement.setInt(2, studentId);

            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected>0){
                System.out.println("Student course updated successfully!");
            }
            else {
                System.out.println("No student found with ID: " + studentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentById(int studentId) {
        String query = "DELETE FROM students WHERE id = ?";

        try(
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
                )
        {
            preparedStatement.setInt(1, studentId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected>0){
                System.out.println("Student data deleted successfully!");
            }
            else {
                System.out.println("No student found with ID: " + studentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateStudentInput(String name, String email, String course) throws InvalidInputException {
        if(name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Student name cannot be empty.");
        }
        if(email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new InvalidInputException("Invalid email address.");
        }
        if(course == null || course.trim().isEmpty()) {
            throw new InvalidInputException("Course cannot be empty.");
        }
    }
}
