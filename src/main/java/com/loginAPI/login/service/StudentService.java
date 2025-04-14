package com.loginAPI.login.service;

import com.loginAPI.login.model.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getStudents();
    Student getStudentById(Long id);
    Boolean updateStudent(Long id,Student student);
    Boolean deleteStudent(Long id);
}
