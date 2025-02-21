package com.dhana.rabbitmq.consumer;

import com.dhana.rabbitmq.module.Student;
import com.dhana.rabbitmq.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class.getName());

    private final StudentRepository studentRepository;

    public ConsumerService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = "${rabbitmq.student.queue.name}")
    public void receive(String message) {
        logger.info("receive message: {}", message);
    }

    @RabbitListener(queues = "${rabbitmq.student.queue.name}")
    public void receiveStudent(Student student) {
        logger.info("receive student record: {}", student);
        studentRepository.save(student);
        logger.info("Student record '{}' saved sucessfully", student);
    }

    @RabbitListener(queues = "${rabbitmq.name.queue.name}")
    public void deleteStudent(String name) {
        logger.info("receive delete request: {}", name);
        studentRepository.deleteByName(name);
        logger.info("Student with name '{}' deleted successfully.", name);
    }
}
