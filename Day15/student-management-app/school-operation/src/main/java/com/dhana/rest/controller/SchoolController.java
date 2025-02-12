package com.dhana.rest.controller;

import com.dhana.rest.model.School;
import com.dhana.rest.repository.SchoolRepository;
import com.dhana.rest.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class SchoolController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolController.class);

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody final School student){
        System.out.println("Saving Student Data: " + student);
        schoolService.save(student);
        LOGGER.info("Save Students Data");
        return ResponseEntity.ok("Student Data Saved");
    }

    @GetMapping("/read")
    public ResponseEntity<List<School>> getAllStudents(){
        LOGGER.info("Get All Student Data");
        List <School> students = (List <School>) schoolService.getAllStudents();
        return ResponseEntity.ok(students);
    }


    @PutMapping("/updateAge")
    public ResponseEntity<String> updateAge(String name, Integer age) {
        LOGGER.info("Update Student Age Using Name");
        int newAge = schoolService.updateAge(name, age);
        return ResponseEntity.ok("Student Age Updated Successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(String name) {
        LOGGER.info("Delete Student Record Using Name");
        int deletedStudent = schoolService.delete(name);
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}