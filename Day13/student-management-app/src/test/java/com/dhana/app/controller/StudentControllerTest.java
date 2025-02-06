package com.dhana.app.controller;

import com.dhana.app.model.Student;
import com.dhana.app.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.client.ExpectedCount;

import java.util.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {
    @InjectMocks
    StudentController studentController;
    @Mock
    StudentRepository studentRepository;

    @Test
    public void testSaveStudents() {

        Student student1 = new Student(1, "John", "ABCSchool", 15, "F");
        when(studentRepository.save(student1)).thenReturn(student1);
        Student resultStudent = studentRepository.save(student1);
        assert resultStudent!=null;
        assert resultStudent.getId()==student1.getId();
        assert resultStudent.getName().equals("John");
        assert resultStudent.getSchoolName().equals("ABCSchool");
        assert resultStudent.getAge()==(15);
        assert resultStudent.getGender().equals("F");
    }

    @Test
    public void testGetStudents() {

        Map<String, Student> studentMap = new HashMap<>();
        Student student1 = new Student(1, "John", "ABCSchool", 15, "F");
        Student student2 = new Student(2, "Bane", "ABDSchool", 18, "M");
        Student student3 = new Student(3, "Jane", "ABESchool", 17, "F");
        studentMap.put(student1.getName(), student1);
        when(studentController.read()).thenReturn(studentMap.values());
        Iterable<Student> resultStudent = studentController.read();
        assert resultStudent!=null;
    }


}
