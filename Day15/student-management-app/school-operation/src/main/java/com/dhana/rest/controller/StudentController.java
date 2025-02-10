package com.dhana.rest.controller;

import com.dhana.rest.model.Student;
import com.dhana.rest.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/save")
    public String save(@RequestBody final Student student){
        System.out.println("Saving Student Data: " + student);
        studentRepository.save(student);
        return "Student Data Saved";
    }

    @GetMapping("/read")
    public Iterable<Student> read() {
        return studentRepository.findAll();
    }

    @PutMapping("/updateAge")
    public ResponseEntity<String> updateAge(String name, Integer age) {
        int newAge = studentRepository.updateStudentAgeByName(name, age);
        return ResponseEntity.ok("Student Age Updated Successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(String name) {
        int deletedStudent = studentRepository.deleteStudentByName(name);
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}