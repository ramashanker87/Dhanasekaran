package com.digital.parking.app.controller;

import com.digital.parking.app.model.Car;
import com.digital.parking.app.model.ParkingEnd;
import com.digital.parking.app.model.ParkingStart;
import com.digital.parking.app.service.ParkingService;
import com.digital.parking.app.service.RabbitMqSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    private static final Logger logger = LoggerFactory.getLogger(ParkingController.class.getName());
    private final ParkingService parkingService;
    private final RabbitMqSender rabbitMqSender;

    public ParkingController(ParkingService parkingService, RabbitMqSender rabbitMqSender) {
        this.parkingService = parkingService;
        this.rabbitMqSender = rabbitMqSender;
    }

    @PostMapping("/register")
    public ParkingStart registerParking(@RequestBody Car car, @RequestParam String parkingNumber) {
        ParkingStart regPark = rabbitMqSender.parkingStart(car, parkingNumber);
        return regPark;
    }

    @PostMapping("/close")
    public ParkingEnd closeParking(@RequestParam String regNumber) {
        ParkingEnd endPark = rabbitMqSender.parkingStop(regNumber);
        return endPark;
    }

    @GetMapping("/retrieve/active")
    public ParkingStart getParking(@RequestParam String regNumber) {
        ParkingStart parkingStatus = parkingService.getParking(regNumber);
        return parkingStatus;
    }

    @GetMapping("/retrieve/ended")
    public ParkingEnd getEndParking(@RequestParam String regNumber) {
        ParkingEnd parkingEndStatus = parkingService.getEndedParking(regNumber);
        return parkingEndStatus;
    }
}
