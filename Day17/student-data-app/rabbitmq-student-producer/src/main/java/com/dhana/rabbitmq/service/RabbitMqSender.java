package com.dhana.rabbitmq.service;

import com.dhana.rabbitmq.module.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqSender.class.getName());

    private final AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange.name}")
    String exchangeName;

    @Value("${rabbitmq.student.routingkey.name}")
    String studentRoutingKeyName;

    @Value("${rabbitmq.name.routingkey.name}")
    String nameRoutingKeyName;

    public RabbitMqSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send(String message) {
        logger.info("Sending Message: {}", message);
        amqpTemplate.convertAndSend(exchangeName, studentRoutingKeyName, message.toString());
    }

    public void saveStudent(Student student) {
        logger.info("Sending Student Details Message: {}", student);
        amqpTemplate.convertAndSend(exchangeName, studentRoutingKeyName, student);
    }

    public void deleteStudent(String name) {
        logger.info("Deleting Student Record Message: {}", name);
        amqpTemplate.convertAndSend(exchangeName, studentRoutingKeyName, name.toString());
    }










}
