# Student Management System (Java Backend)

A console-based **Java backend application** built using **Core Java, JDBC, Maven, and MySQL**.  
The project implements full CRUD (Create, Read, Update, Delete) functionality with secure database access, input validation, and a clean layered architecture.

This project focuses on strengthening backend fundamentals such as database connectivity, exception handling, and separation of concerns.

---

## Features
- Add new students
- View all students
- Update student course details
- Delete students by ID
- Input validation using custom exceptions
- Secure SQL execution using `PreparedStatement`
- Menu-driven console interface

---

## Tech Stack
- **Java**
- **JDBC**
- **MySQL**
- **Maven**
- **Git & GitHub**

---

## Project Structure
```
src/
 ├── main/
 │   ├── java/
 │   │   └── com/student/
 │   │       ├── dao/        # Database access logic
 │   │       ├── util/       # Database connection utility
 │   │       ├── exception/  # Custom exceptions
 │   │       └── Main.java   # Application entry point
 └── resources/
```

---

## Database Setup
1. Create a MySQL database:
   ```sql
   CREATE DATABASE student_db;
   ```

2. Create the `students` table:
   ```sql
   CREATE TABLE students (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       email VARCHAR(100) UNIQUE NOT NULL,
       course VARCHAR(50) NOT NULL
   );
   ```

---

## Environment Configuration
This project uses a `.env` file to manage database credentials securely.

Create a `.env` file in the project root with the following content:
```env
DB_URL=jdbc:mysql://localhost:3306/student_db
DB_USER=root
DB_PASSWORD=your_password_here
```

> ⚠️ The `.env` file is ignored by Git and should not be committed.

---

## How to Run
1. Ensure MySQL Server is running
2. Update database credentials in the `.env` file
3. Open the project in IntelliJ IDEA
4. Run `Main.java`
5. Use the console menu to perform operations

---

## Learning Outcomes
- Understanding JDBC and database connectivity in Java
- Implementing DAO-based architecture
- Writing secure SQL queries using `PreparedStatement`
- Handling input validation with custom exceptions
- Managing environment variables securely
- Using Maven for dependency management

---

## Future Improvements
- Return objects instead of printing directly from DAO
- Add logging instead of `System.out.println`
- Migrate the project to Spring Boot
- Expose REST APIs

---

## Author
Developed as a learning project to strengthen Java backend development skills.
