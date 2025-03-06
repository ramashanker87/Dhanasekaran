package com.digital.parking.app.service;

import com.digital.parking.app.model.Car;
import com.digital.parking.app.model.ParkingEnd;
import com.digital.parking.app.model.ParkingStart;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ParkingService {
    private final Map<String, ParkingStart> newParking = new HashMap<>();
    private final Map<String, ParkingEnd> endedParking = new HashMap<>();

    public ParkingStart startParking(Car car, String parkingNumber) {
        ParkingStart parkingStart = new ParkingStart(parkingNumber, LocalDateTime.now(), car.getRegNumber(), "ACTIVE");
        newParking.put(car.getRegNumber(), parkingStart);
        return parkingStart;
    }

    public ParkingStart getParking(String regNumber) {
        ParkingStart parkingStatus = newParking.get(regNumber);
        if (parkingStatus == null) {
            throw new IllegalStateException("No Active parking found for regNumber: " + regNumber);
        }
        return parkingStatus;
    }
    public ParkingEnd getEndedParking(String regNumber) {
        ParkingEnd parkingEndStatus = endedParking.get(regNumber);
        if (parkingEndStatus == null) {
            throw new IllegalStateException("No Ended parking found for regNumber: " + regNumber);
        }
        return parkingEndStatus;
    }

    public ParkingEnd endParking(String regNumber) {
        ParkingStart parkingStart = newParking.remove(regNumber);
        ParkingEnd parkingEnd = new ParkingEnd(
                parkingStart.getParkingNumber(),
                parkingStart.getStartTime(),
                LocalDateTime.now(),
                "ENDED",
                parkingStart.getRegNumber());

        endedParking.put(regNumber, parkingEnd);
        return parkingEnd;
    }
}
