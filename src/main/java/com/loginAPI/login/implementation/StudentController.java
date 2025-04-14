package com.loginAPI.login.implementation;

import com.loginAPI.login.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    StudentService service;
    StudentController(StudentService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(service.getStudents());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student>getStudentById(@PathVariable Long id){
        Student student= service.getStudentById(id);
        if(student!=null){
            return new ResponseEntity<>(student,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        service.addStudent(student);
        return new ResponseEntity<>("created",HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id,@RequestBody Student student){
        if(service.updateStudent(id,student)){
            return new ResponseEntity<>("updated", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("update fails",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        if(service.deleteStudent(id)){
            return new ResponseEntity<>("deleted",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("deletion fails",HttpStatus.NOT_FOUND);
        }
    }
}
