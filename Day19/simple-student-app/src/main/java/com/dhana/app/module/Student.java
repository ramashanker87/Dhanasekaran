package com.dhana.app.module;

public class Student {
    private String name;
    private Integer id;

    public Student() {}
    public Student(String name, Integer id) {
        super();
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
