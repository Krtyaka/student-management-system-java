package com.student;

import com.student.dao.StudentDAO;
import com.student.exception.InvalidInputException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        while (true) {
            System.out.println("\n---- Student Management System ----");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Course");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = in.nextInt();
            in.nextLine();

            try{
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = in.nextLine();

                        System.out.print("Enter email: ");
                        String email = in.nextLine();

                        System.out.print("Enter course: ");
                        String course = in.nextLine();

                        studentDAO.addStudent(name, email, course);
                        break;

                    case 2:
                        studentDAO.getAllStudents();
                        break;

                    case 3:
                        System.out.print("Enter student ID: ");
                        int id = in.nextInt();
                        in.nextLine();

                        System.out.print("Enter new course: ");
                        String newCourse = in.nextLine();

                        studentDAO.updateStudentCourse(id, newCourse);
                        break;

                    case 4:
                        System.out.print("Enter student ID: ");
                        int deleteId = in.nextInt();
                        in.nextLine();

                        studentDAO.deleteStudentById(deleteId);
                        break;

                    case 5:
                        System.out.println("Exiting application");
                        return;

                    default:
                        System.out.println("Invalid option! Try again.");
                }
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
