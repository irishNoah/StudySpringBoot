package com.example.StudySpringBoot.repository;

import com.example.StudySpringBoot.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TeacherRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper를 사용하여 ResultSet을 Teacher 객체로 변환
    private RowMapper<Teacher> teacherRowMapper = new RowMapper<Teacher>() {
        @Override
        public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
            Teacher teacher = new Teacher();
            teacher.setId(rs.getLong("id"));
            teacher.setName(rs.getString("name"));
            teacher.setSubject(rs.getString("subject"));
            teacher.setEmail(rs.getString("email"));
            return teacher;
        }
    };

    public List<Teacher> findAll() {
        String sql = "SELECT * FROM Teacher";
        return jdbcTemplate.query(sql, teacherRowMapper);
    }

    public Teacher findById(Long id) {
        String sql = "SELECT * FROM Teacher WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, teacherRowMapper, id);
    }

    public int save(Teacher teacher) {
        String sql = "INSERT INTO Teacher (name, subject, email) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, teacher.getName(), teacher.getSubject(), teacher.getEmail());
    }

    public int update(Teacher teacher) {
        String sql = "UPDATE Teacher SET name = ?, subject = ?, email = ? WHERE id = ?";
        return jdbcTemplate.update(sql, teacher.getName(), teacher.getSubject(), teacher.getEmail(), teacher.getId());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM Teacher WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}