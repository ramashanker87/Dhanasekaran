package com.digital.parking.app.model;

import java.time.LocalDateTime;

public class ParkingEnd {
    private String parkingNo;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int price;
    private String status;
    private String regNumber;

    @Override
    public String toString() {
        return "parkingNo='" + parkingNo + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", regNumber='" + regNumber + '\'' +
                '}';
    }

    public ParkingEnd() {}
    public ParkingEnd(String parkingNo, LocalDateTime startTime, LocalDateTime endTime, int price, String status, String regNumber) {
        super();
        this.parkingNo = parkingNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.status = status;
        this.regNumber = regNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

}
