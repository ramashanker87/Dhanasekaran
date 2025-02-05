package com.dhana.app.controller;

import com.dhana.app.model.Student;
import com.dhana.app.repository.StudentRepository;
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


}
