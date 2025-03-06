package com.digital.parking.app.service;

import com.digital.parking.app.model.Car;
import com.digital.parking.app.model.ParkingEnd;
import com.digital.parking.app.model.ParkingStart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class RabbitMqSender {
    private final Map<String, ParkingStart> newParking = new HashMap<>();
    private final Map<String, ParkingEnd> endedParking = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqSender.class.getName());

    private final AmqpTemplate amqpTemplate;

    public RabbitMqSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Value("${rabbitmq.exchange.name}")
    String exchangeName;

    @Value("${rabbitmq.start.request.routingkey.name}")
    String startParkingRoutingKey;

    @Value("${rabbitmq.end.request.routingkey.name}")
    String endParkingRoutingKey;

    public ParkingStart parkingStart(Car car, String parkingNumber) {
        ParkingStart parkStart = new ParkingStart(parkingNumber, LocalDateTime.now(), car.getRegNumber(), "ACTIVE");
        newParking.put(car.getRegNumber(), parkStart);
        //return parkingStart;
        logger.info("Start Parking Car Notification: {}", car.toString());
        amqpTemplate.convertAndSend(exchangeName, startParkingRoutingKey, parkStart);
        logger.info("Parking Information: {}", parkStart);
        return parkStart;
    }

    public ParkingEnd parkingStop(String regNumber) {
        ParkingStart parkingStart = newParking.remove(regNumber);
        ParkingEnd parkingEnd = new ParkingEnd(
                parkingStart.getParkingNumber(),
                parkingStart.getStartTime(),
                LocalDateTime.now(),
                "ENDED",
                parkingStart.getRegNumber());
        endedParking.put(regNumber, parkingEnd);
        logger.info("End Parking Car Notification: {}", endedParking);
        amqpTemplate.convertAndSend(exchangeName, endParkingRoutingKey, parkingEnd);
        return parkingEnd;
    }
}

