package com.dhana.rabbitmq.controller;
import com.dhana.rabbitmq.module.Student;
import com.dhana.rabbitmq.service.RabbitMqSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class ProducerController {
    private final static Logger logger = LoggerFactory.getLogger(ProducerController.class.getName());

    private final RabbitMqSender rabbitMqSender;

    public ProducerController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    @GetMapping("/send")
    public String send(@RequestParam("msg") String message) {
        logger.info("send message: {}", message);
        rabbitMqSender.send(message);
        return message;
    }

    @PostMapping("/save")
    public Student student(@RequestBody Student student) {
        rabbitMqSender.sendStudent(student);
        return student;
    }
}
