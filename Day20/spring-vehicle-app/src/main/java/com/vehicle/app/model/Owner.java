package com.vehicle.app.model;

public class Owner {
    private String Name;
    private String address;
    private String age;

    public Owner() {}
    public Owner(String name, String address, String age) {
        super();
        Name = name;
        this.address = address;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
