package com.loginAPI.login;

import com.loginAPI.login.implementation.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImp implements StudentService {
    StudentRepository studentRepository;
    StudentImp(StudentRepository repository){
        studentRepository=repository;
    }
    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean updateStudent(Long id, Student student) {
            Optional<Student> optionalStudent=studentRepository.findById(id);
            if(optionalStudent.isPresent()){
                Student student1=optionalStudent.get();
                student1.setName(student.getName());
                student1.setPhNo(student.getPhNo());
                student1.seteMail(student.geteMail());
                studentRepository.save(student1);
                return true;
            }else{
                return false;
            }
    }

    @Override
    public Boolean deleteStudent(Long id) {
        try {
             studentRepository.deleteById(id);
             return true;
        } catch (Exception e) {
            return false;
        }
    }
}
