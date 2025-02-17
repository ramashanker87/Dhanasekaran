package com.vehicle.app.model;

public class Registration {
    private Owner owner;
    private Vehicle vehicle;

    public Registration() {}
    public Registration(Owner owner, Vehicle vehicle) {
        super();
        this.owner = owner;
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


}
