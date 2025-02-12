package com.dhana.rest.repository;

import com.dhana.rest.model.School;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {

    @Query("select s from Student s")
    List<School> getAllStudents();

    @Modifying
    @Transactional
    @Query("update Student s SET s.age = :age where s.name = :name")
    int updateStudentAgeByName(String name, Integer age);

    @Modifying
    @Transactional
    @Query("delete from Student s where s.name = :name")
    int deleteStudentByName(String name);
}
