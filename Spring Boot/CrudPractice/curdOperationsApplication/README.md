# Spring Boot CRUD Without Spring Data JPA — Student Management API

A reference guide for building CRUD operations in Spring Boot using **`JdbcTemplate`** instead of Spring Data JPA, based on a `Student` entity example. Covers the full layered architecture, `ResponseEntity` usage, and a real-world debugging case with `KeyHolder`.

---

## Table of Contents

1. [Architecture Overview](#architecture-overview)
2. [Entity Layer](#entity-layer)
3. [Repository Layer](#repository-layer)
4. [Service Layer](#service-layer)
5. [Controller Layer](#controller-layer)
6. [Understanding `ResponseEntity`](#understanding-responseentity)
7. [Bug Fix: JDBC Parameter Order Mismatch](#bug-fix-jdbc-parameter-order-mismatch)
8. [Bug Fix: `KeyHolder` Multiple Keys Exception](#bug-fix-keyholder-multiple-keys-exception)
9. [Key Takeaways](#key-takeaways)

---

## Architecture Overview

Without Spring Data JPA, the standard layered flow still applies — only the repository implementation changes (raw SQL instead of auto-generated queries):

```
Controller → Service → Repository (JdbcTemplate) → Database
```

| Layer | Responsibility |
|---|---|
| **Controller** | Handles HTTP requests/responses, delegates to service |
| **Service** | Business logic, orchestrates repository calls |
| **Repository** | Writes and executes raw SQL via `JdbcTemplate` |
| **Entity** | Plain data model (POJO) |

> **Note:** JPA annotations (`@Entity`, `@Id`, `@GeneratedValue`) are ignored when using plain `JdbcTemplate` — they only take effect when a JPA provider (like Hibernate) scans the class. Keep them only if you may switch to JPA/Hibernate later.

---

## Entity Layer

```java
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;
    private int rollNo;
    private String subject;

    public StudentEntity() {
    } // required no-arg constructor for reflection-based instantiation

    public StudentEntity(String name, int age, String email, int rollNo, String subject) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.rollNo = rollNo;
        this.subject = subject;
    }

    // standard getters and setters
}
```

**Common mistakes caught:**
- Missing no-arg constructor — required by JPA and mapping utilities like `BeanPropertyRowMapper` for reflection-based object creation.
- Forgetting to assign a constructor parameter to its field (e.g. `subject` accepted but never set).

---

## Repository Layer

### Interface
```java
public interface StudentRepositoryHandler {
    StudentEntity save(StudentEntity student);
    StudentEntity findById(Long id);
    List<StudentEntity> getAllStudents();
    void update(StudentEntity student);
    void deleteById(Long id);
}
```

### Implementation (`JdbcTemplate`)
```java
@Repository
public class StudentRepositoryIMP implements StudentRepositoryHandler {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepositoryIMP(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public StudentEntity save(StudentEntity student) {
        String sql = "INSERT INTO student_entity (name, age, email, roll_no, subject) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getEmail());
            ps.setInt(4, student.getRollNo());
            ps.setString(5, student.getSubject());
            return ps;
        }, keyHolder);

        Number id = (Number) keyHolder.getKeys().get("id");
        student.setId(id.longValue());

        return student;
    }

    @Override
    public StudentEntity findById(Long id) {
        String sql = "SELECT * FROM student_entity WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(StudentEntity.class), id);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        String sql = "SELECT * FROM student_entity";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentEntity.class));
    }

    @Override
    public void update(StudentEntity student) {
        String sql = "UPDATE student_entity SET name=?, age=?, email=?, roll_no=?, subject=? WHERE id=?";
        jdbcTemplate.update(sql,
                student.getName(), student.getAge(), student.getEmail(),
                student.getRollNo(), student.getSubject(), student.getId());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM student_entity WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
```

> **Rule of thumb:** SQL `?` placeholder position must exactly match the order of `ps.setXxx(position, value)` calls. Write the SQL column list and the `set` calls in the same visual order to avoid silent data corruption from swapped columns.

---

## Service Layer

```java
@Service
public class StudentService {

    private final StudentRepositoryHandler studentRepository;

    public StudentService(StudentRepositoryHandler studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity createStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public StudentEntity getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void updateStudent(StudentEntity student) {
        studentRepository.update(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
```

The service layer never contains SQL — it only orchestrates business logic and delegates persistence to the repository.

---

## Controller Layer

```java
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentEntity> create(@RequestBody StudentEntity studentEntity) {
        StudentEntity saved = studentService.createStudent(studentEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable Long id) {
        StudentEntity student = studentService.getStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping
    public ResponseEntity<Void> updateStudent(@RequestBody StudentEntity student) {
        studentService.updateStudent(student);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
```

---

## Understanding `ResponseEntity`

`ResponseEntity` represents the **full HTTP response** — status code, headers, and body — giving explicit control instead of relying on Spring's default status inference.

| Method | Status Code | When to Use |
|---|---|---|
| `ok(...)` | 200 | Successful `GET` / `PUT`, returning a resource |
| `created(uri)` | 201 | Successful `POST` creating a new resource (include `Location` header) |
| `noContent()` | 204 | Successful `DELETE` or update with no response body |
| `badRequest()` | 400 | Invalid client input / validation failure |
| `notFound()` | 404 | Requested resource doesn't exist |
| `status(HttpStatus.CONFLICT)` | 409 | Duplicate resource / conflict |
| `status(HttpStatus.INTERNAL_SERVER_ERROR)` | 500 | Unexpected server error |

Example of a `201 Created` response with a `Location` header:

```java
@PostMapping
public ResponseEntity<StudentEntity> create(@RequestBody StudentEntity studentEntity) {
    StudentEntity saved = studentService.createStudent(studentEntity);
    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(saved.getId())
            .toUri();
    return ResponseEntity.created(location).body(saved);
}
```

Most factory methods return a `BodyBuilder`, so `.body(...)` or `.build()` must be chained to complete the response.

---

## Bug Fix: JDBC Parameter Order Mismatch

**Symptom:** Wrong values inserted into wrong columns (e.g. `age` and `roll_no` swapped).

**Cause:** The `?` placeholder index in `ps.setXxx(index, value)` didn't match the actual column order in the SQL statement.

**Before (buggy):**
```java
ps.setString(1, student.getName());
ps.setInt(3, student.getAge());       // wrong index
ps.setString(4, student.getEmail());  // wrong index
ps.setInt(2, student.getRollNo());    // wrong index
ps.setString(5, student.getSubject());
```

**After (fixed):**
```java
ps.setString(1, student.getName());   // name
ps.setInt(2, student.getAge());       // age
ps.setString(3, student.getEmail());  // email
ps.setInt(4, student.getRollNo());    // roll_no
ps.setString(5, student.getSubject());// subject
```

**Lesson:** Keep the SQL column list and the `set` calls visually aligned, top to bottom, so mismatches are easy to spot.

---

## Bug Fix: `KeyHolder` Multiple Keys Exception

### Error
```
org.springframework.dao.InvalidDataAccessApiUsageException:
The getKey method should only be used when a single key is returned.
The current key entry contains multiple keys:
[{id=1, age=22, email=..., name=..., roll_no=54, subject=java}]
```

### Root Cause
`Statement.RETURN_GENERATED_KEYS` caused the JDBC driver to return the **entire inserted row** (all columns), not just the generated `id`. Calling `keyHolder.getKey()` fails because it only supports a single-column, single-key result.

### Fix
Use `getKeys()` (plural) to retrieve the full result map, then extract the `id` column by name:

```java
Number id = (Number) keyHolder.getKeys().get("id");
student.setId(id.longValue());
```

### Why this works
- `getKey()` → throws if more than one column is returned by the driver.
- `getKeys()` → returns the complete `Map<String, Object>`, letting you safely pick the specific column you need.

### Alternative Approach
Restrict the statement to only return the `id` column:
```java
PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
```
This can work but is driver-dependent and less portable than using `getKeys()`.

---

## Key Takeaways

- Without Spring Data JPA, the **Controller → Service → Repository** layering stays identical — only the repository implementation changes to use `JdbcTemplate` (or plain JDBC/Hibernate) with hand-written SQL.
- Always include a **no-arg constructor** in entity classes for reflection-based frameworks and mappers.
- SQL parameter indices must exactly match the column order — misalignment causes silent data corruption, not always a visible error.
- Use the correct `ResponseEntity` factory method to communicate accurate HTTP semantics to API clients (`201` for creation, `204` for no-content responses, `404` for missing resources, etc.).
- When using `KeyHolder`, prefer `getKeys()` over `getKey()` unless you're certain the driver returns exactly one generated column — this avoids `InvalidDataAccessApiUsageException` in multi-column return scenarios.