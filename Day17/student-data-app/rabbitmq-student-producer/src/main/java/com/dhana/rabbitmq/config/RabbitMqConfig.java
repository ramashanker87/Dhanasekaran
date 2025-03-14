package com.dhana.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.exchange.name}")
    String exchangeName;

    @Value("${rabbitmq.student.queue.name}")
    String studentQueueName;

    @Value("${rabbitmq.student.routingkey.name}")
    String studentRoutingKeyName;

    @Value("${rabbitmq.name.queue.name}")
    String nameQueueName;

    @Value("${rabbitmq.name.routingkey.name}")
    String nameRoutingKeyName;

    @Bean
    public Queue studentQueue() {
        return new Queue(studentQueueName, true);
    }
    @Bean
    public Queue nameQueue() {
        return new Queue(nameQueueName, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding studentBinding(Queue studentQueue, DirectExchange exchange) {
        return BindingBuilder.bind(studentQueue).to(exchange).with(studentRoutingKeyName);
    }

    @Bean
    public Binding nameBinding(Queue nameQueue, DirectExchange exchange) {
        return BindingBuilder.bind(nameQueue).to(exchange).with(nameRoutingKeyName);
    }

    @Bean
    public MessageConverter JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setMessageConverter(JsonMessageConverter());
        return rabbitTemplate;
    }

}
