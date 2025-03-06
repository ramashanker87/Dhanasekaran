package com.digital.parking.app.config;

import com.digital.parking.app.model.ParkingEnd;
import com.digital.parking.app.model.ParkingStart;
import com.digital.parking.app.model.ParkingStatus;
import com.digital.parking.app.repository.ParkingStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqListener {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqListener.class.getName());

    private final ParkingStatusRepository parkingStatusRepository;

    public RabbitMqListener(ParkingStatusRepository parkingStatusRepository) {
        this.parkingStatusRepository = parkingStatusRepository;
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = "${rabbitmq.start.request.queue.name}")
    public void receiveStartStatusParking(ParkingStatus parkingStatus) {
        logger.info("Received Car Start Parking Status Notification: {}", parkingStatus.toString());
        parkingStatusRepository.save(parkingStatus);
        System.out.println("Start Parking Stored in MySQL: " + parkingStatus.getRegNumber());
        logger.info("Start Parking Information: {}", parkingStatus);
    }

    @RabbitListener(queues = "${rabbitmq.end.request.queue.name}")
    public void receiveEndStatusParking(ParkingStatus parkingStatus) {
        logger.info("Received Car End Parking Status Notification: {}", parkingStatus);
        parkingStatusRepository.save(parkingStatus);
        System.out.println("End Parking Stored in MySQL: " + parkingStatus.getRegNumber());
        logger.info("End Parking Information: {}", parkingStatus);
    }
}
