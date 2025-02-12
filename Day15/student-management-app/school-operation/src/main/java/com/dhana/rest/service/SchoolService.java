package com.dhana.rest.service;

import com.dhana.rest.model.School;
import com.dhana.rest.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School save(School student) {
        return schoolRepository.save(student);
    }

    public List<School> getAllStudents() {
        return (List<School>) schoolRepository.findAll();
    }

    public int updateAge(String name, Integer age) {
        return schoolRepository.updateStudentAgeByName(name, age);
    }

    public int delete(String name) {
        return schoolRepository.deleteStudentByName(name);
    }
}
