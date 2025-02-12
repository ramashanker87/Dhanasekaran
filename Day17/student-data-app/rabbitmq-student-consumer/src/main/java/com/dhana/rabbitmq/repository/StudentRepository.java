package com.dhana.rabbitmq.repository;

import com.dhana.rabbitmq.module.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.name = :name")
    int deleteByName(String name);
}
