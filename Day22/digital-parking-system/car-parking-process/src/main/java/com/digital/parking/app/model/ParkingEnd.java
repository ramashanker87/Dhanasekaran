package com.digital.parking.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
public class ParkingEnd {

    @Id
    private String parkingNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer price;
    private String parkingStatus;
    private String regNumber;


    @Override
    public String toString() {
        return "ParkingEnd{" +
                "parkingNumber='" + parkingNumber + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", parkingStatus='" + parkingStatus + '\'' +
                ", regNumber='" + regNumber + '\'' +
                '}';
    }

    public ParkingEnd() {}
    public ParkingEnd(String parkingNumber, LocalDateTime startTime, LocalDateTime endTime, String parkingStatus, String regNumber) {
        super();
        this.parkingNumber = parkingNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = calculatePrice();
        this.parkingStatus = parkingStatus;
        this.regNumber = regNumber;
    }

    private Integer calculatePrice() {
        double perMinutePrice = 5.0;
        Duration duration = Duration.between(startTime,endTime);
        long parkedDuration = duration.toMinutes();
        double finalPrice = parkedDuration * perMinutePrice;
        return (int) Math.ceil(finalPrice);
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(String parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public Integer getPrice() {
        return price;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        this.price = calculatePrice();
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
