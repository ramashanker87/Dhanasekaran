package com.digital.parking.app.model;

public class Car {
    private String ownerName;
    private String regNumber;
    private String carModel;
    private String fuelType;

    @Override
    public String toString() {
        return "Car{" +
                "ownerName='" + ownerName + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", carModel='" + carModel + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }

    public Car() {}
    public Car(String ownerName, String regNumber, String carModel, String fuelType) {
        super();
        this.ownerName = ownerName;
        this.regNumber = regNumber;
        this.carModel = carModel;
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

}
