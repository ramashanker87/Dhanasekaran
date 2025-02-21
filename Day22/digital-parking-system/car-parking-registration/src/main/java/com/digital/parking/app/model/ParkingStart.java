package com.digital.parking.app.model;

import java.time.LocalDateTime;

public class ParkingStart {
    private String parkingNumber;
    private LocalDateTime startTime;
    private String regNumber;
    private String status;

    @Override
    public String toString() {
        return "ParkingStart{" +
                "parkingNumber='" + parkingNumber + '\'' +
                ", startTime=" + startTime +
                ", regNumber='" + regNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public ParkingStart() {}
    public ParkingStart(String parkingNumber, LocalDateTime startTime, String regNumber, String status) {
        super();
        this.parkingNumber = parkingNumber;
        this.startTime = startTime;
        this.regNumber = regNumber;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegNo() {
        return regNumber;
    }

    public void setRegNo(String regNo) {
        this.regNumber = regNo;
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
