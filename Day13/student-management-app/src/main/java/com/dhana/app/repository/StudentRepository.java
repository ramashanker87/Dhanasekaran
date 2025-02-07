package com.dhana.app.repository;

import com.dhana.app.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
