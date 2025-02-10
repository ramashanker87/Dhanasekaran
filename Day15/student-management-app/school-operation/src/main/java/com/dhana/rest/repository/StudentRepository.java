package com.dhana.rest.repository;

import com.dhana.rest.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Modifying
    @Transactional
    @Query("update Student s SET s.age = :age where s.name = :name")
    int updateStudentAgeByName(String name, Integer age);

    @Modifying
    @Transactional
    @Query("delete from Student s where s.name = :name")
    int deleteStudentByName(String name);
}
