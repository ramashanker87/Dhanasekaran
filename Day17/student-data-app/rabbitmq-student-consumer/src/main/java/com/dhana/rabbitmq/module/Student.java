package com.dhana.rabbitmq.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private Long id;
    private String name;
    private String schoolName;
    private int age;
    private String gender;

    public Student() {}
    public Student(String gender, int age, String schoolName, String name, Long id) {
        super();
        this.gender = gender;
        this.age = age;
        this.schoolName = schoolName;
        this.name = name;
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", schoolName=" + schoolName + ", age=" + age + ", gender=" + gender + "]";
    }


}
