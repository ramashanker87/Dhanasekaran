/*
package com.dhana.app.controller;

import com.dhana.app.model.Student;
import com.dhana.app.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {
    @InjectMocks
    StudentController studentController;
    @Mock
    StudentRepository studentRepository;

    @Test
    public void testSaveStudents() {

        Student student = new Student(1L, "John", "ABCSchool", 15, "M");
        when(studentRepository.save(student)).thenReturn(student);
        Student resultStudent = studentController.save(student.getId(), 1L);
        assert resultStudent!=null;
    }
}
*/
