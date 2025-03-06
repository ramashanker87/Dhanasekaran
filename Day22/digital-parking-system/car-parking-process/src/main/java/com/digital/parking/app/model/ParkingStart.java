package com.digital.parking.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class ParkingStart {
    @Id
    private String parkingNumber;
    private LocalDateTime startTime;
    private String regNumber;
    private String parkingStatus;


    @Override
    public String toString() {
        return "ParkingStart{" +
                "parkingNumber='" + parkingNumber + '\'' +
                ", startTime=" + startTime +
                ", regNumber='" + regNumber + '\'' +
                ", parkingStatus='" + parkingStatus + '\'' +
                '}';
    }

    public ParkingStart(){}
    public ParkingStart(String parkingNumber, LocalDateTime startTime, String regNumber, String parkingStatus) {
        super();
        this.parkingNumber = parkingNumber;
        this.startTime = startTime;
        this.regNumber = regNumber;
        this.parkingStatus = parkingStatus;
    }

    public String getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(String parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(String parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

}

