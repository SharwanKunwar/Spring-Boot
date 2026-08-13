# CRUD Operations Application

This is a simple Spring Boot project for practicing CRUD operations with a `StudentEntity`.

The current project mainly demonstrates the create flow for a student record. A request comes into the REST controller, moves through the service layer, then reaches a manual repository class. The read, update, and delete operations are planned but not fully implemented yet.

## What This Project Is About

This application is a learning/practice project for understanding how a Spring Boot backend is organized.

It shows:

- How to create a Spring Boot application
- How to expose REST endpoints with a controller
- How to pass data from controller to service
- How to use a repository-style class for database-related work
- How to define a JPA entity for student data
- How to configure PostgreSQL and Hibernate

## Tech Stack

- Java 21
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Maven
- dotenv-java

## Project Structure

```text
src/main/java/com/unpredictableXpractice/curdOperationsApplication
├── CurdOperationsApplication.java
├── controller
│   └── StudentController.java
├── entity
│   └── StudentEntity.java
├── repository
│   └── ManualStudentRepository.java
└── service
    └── StudentService.java
```

## How The Application Works

### 1. Application Startup

`CurdOperationsApplication.java` starts the Spring Boot application.

It also loads values from a `.env` file using `dotenv-java` and prints those values to the console.

### 2. Student Entity

`StudentEntity.java` represents the student model.

Fields:

- `id`
- `name`
- `age`
- `email`
- `rollNo`
- `subject`

The class is marked with `@Entity`, so Hibernate can map it to a database table.

### 3. Controller Layer

`StudentController.java` exposes API routes under:

```text
/api/students
```

Currently implemented:

```http
POST /api/students
```

This endpoint accepts student data in JSON format and sends it to the service layer.

Example request:

```json
{
  "name": "Ram",
  "age": 20,
  "email": "ram@example.com",
  "rollNo": 1,
  "subject": "Math"
}
```

Example response:

```text
Student create successfully
```

### 4. Service Layer

`StudentService.java` contains the business logic.

Right now it has one method:

```java
createStudent(StudentEntity student)
```

This method receives student data from the controller and passes it to the repository.

### 5. Repository Layer

`ManualStudentRepository.java` is a manually created repository-style component.

At the moment, it does not actually save data using Spring Data JPA. It prints messages to the console and returns the same student object.

Current flow:

```text
Client request
-> StudentController
-> StudentService
-> ManualStudentRepository
-> Response
```

## Database Configuration

The project is configured to use PostgreSQL in `src/main/resources/application.properties`.

Current database URL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/practice_db
```

Hibernate is configured with:

```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

This means Hibernate can automatically create or update tables based on entity classes, and SQL queries will be printed in the console.

## How To Run

Make sure PostgreSQL is running and that a database named `practice_db` exists.

Then run:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start on the default Spring Boot port:

```text
http://localhost:8080
```

## Testing The API

You can test the create student endpoint with curl:

```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Ram",
    "age": 20,
    "email": "ram@example.com",
    "rollNo": 1,
    "subject": "Math"
  }'
```

## Current Status

Implemented:

- Spring Boot application setup
- Student entity
- Student controller
- Student service
- Manual repository component
- Create student endpoint structure
- PostgreSQL and Hibernate configuration

Not fully implemented yet:

- Saving student records with a real Spring Data JPA repository
- Getting all students
- Updating students
- Deleting students
- Request validation
- Error handling

## Important Notes

The project currently stores database credentials directly in `application.properties`. For real projects, it is better to move passwords and other secrets into environment variables or a `.env` file that is not committed to Git.

The project name uses `curdOperationsApplication`, but the common term is `CRUD`, which means Create, Read, Update, and Delete.
