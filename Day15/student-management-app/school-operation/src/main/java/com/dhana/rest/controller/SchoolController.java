package com.dhana.rest.controller;

import com.dhana.rest.model.School;
import com.dhana.rest.repository.SchoolRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class SchoolController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolController.class);

    private final SchoolRepository studentRepository;

    public SchoolController(SchoolRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/save")
    public String save(@RequestBody final School student){
        System.out.println("Saving Student Data: " + student);
        studentRepository.save(student);
        return "Student Data Saved";
    }

    @GetMapping("/read")
    public ResponseEntity<List<School>> getAllStudents(){
        LOGGER.info("Get All Student Data");
        List <School> students = (List <School>) studentRepository.findAll();
        return ResponseEntity.ok(students);
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