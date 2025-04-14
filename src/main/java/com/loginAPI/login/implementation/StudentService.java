package com.loginAPI.login.implementation;

import com.loginAPI.login.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getStudents();
    Student getStudentById(Long id);
    Boolean updateStudent(Long id,Student student);
    Boolean deleteStudent(Long id);
}
