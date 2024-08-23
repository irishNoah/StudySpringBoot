package com.example.StudySpringBoot.service;

import com.example.StudySpringBoot.entity.Teacher;
import com.example.StudySpringBoot.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public void createTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Long id, Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(id);
        teacher.setName(teacherDetails.getName());
        teacher.setSubject(teacherDetails.getSubject());
        teacher.setEmail(teacherDetails.getEmail());
        teacherRepository.update(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}