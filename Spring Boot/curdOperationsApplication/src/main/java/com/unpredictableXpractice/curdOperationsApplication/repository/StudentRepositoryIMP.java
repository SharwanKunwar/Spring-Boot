package com.unpredictableXpractice.curdOperationsApplication.repository;

import com.unpredictableXpractice.curdOperationsApplication.entity.StudentEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class StudentRepositoryIMP implements StudentRepositoryHandler
{
    private final JdbcTemplate jdbcTemplate;

    public StudentRepositoryIMP(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public StudentEntity save(StudentEntity student) {
        String sql = "INSERT INTO student_entity (name, age, email, roll_no, subject) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->
        {
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
    public List<StudentEntity> getAllStudents() {
        String sql = "SELECT * FROM student_entity";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentEntity.class));
    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE FROM student_entity WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM student_entity";
        jdbcTemplate.update(sql);
    }
}
