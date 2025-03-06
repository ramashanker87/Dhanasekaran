/*
package com.digital.parking.app.config;

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

    @Value("${rabbitmq.start.request.queue.name}")
    String startRequest;

    @Value("${rabbitmq.start.response.queue.name}")
    String startResponse;

    @Value("${rabbitmq.end.request.queue.name}")
    String endRequest;

    @Value("${rabbitmq.end.response.queue.name}")
    String endResponse;

    @Value("${rabbitmq.start.request.routingkey.name}")
    String startParkingRoutingKey;

    @Value("${rabbitmq.start.response.routingkey.name}")
    String startParkingResponseRoutingKey;

    @Value("${rabbitmq.end.request.routingkey.name}")
    String endParkingRoutingKey;

    @Value("${rabbitmq.end.response.routingkey.name}")
    String endParkingResponseRoutingKey;

    @Value("${rabbitmq.exchange.name}")
    String exchangeName;

    @Bean
    public Queue startParkingRequestQueue() {
        return new Queue(startRequest, true);
    }

    @Bean
    public Queue startParkingResponseQueue() {
        return new Queue(startResponse, true);
    }

    @Bean
    public Queue endParkingRequestQueue() {
        return new Queue(endRequest, true);
    }

    @Bean
    public Queue endParkingResponseQueue() {
        return new Queue(endResponse, true);
    }

    @Bean
    public DirectExchange parkingExchange() {
        return new DirectExchange(exchangeName);
    }


// Queue Binding with routing key and exchange for start and end requests
    @Bean
    public Binding startRequestBinding(Queue startParkingRequestQueue, DirectExchange parkingExchange) {
        return BindingBuilder.bind(startParkingRequestQueue).to(parkingExchange).with(startParkingRoutingKey);
    }

    @Bean
    public Binding endRequestBinding(Queue endParkingRequestQueue, DirectExchange parkingExchange) {
        return BindingBuilder.bind(endParkingRequestQueue).to(parkingExchange).with(endParkingRoutingKey);
    }

    // Queue Binding with routing key and exchange for start and end responses
    @Bean
    public Binding startResponseBinding(Queue startParkingResponseQueue, DirectExchange parkingExchange) {
        return BindingBuilder.bind(startParkingResponseQueue).to(parkingExchange).with(startParkingResponseRoutingKey);
    }

    @Bean
    public Binding endResponseBinding(Queue endParkingResponseQueue, DirectExchange parkingExchange) {
        return BindingBuilder.bind(endParkingResponseQueue).to(parkingExchange).with(endParkingResponseRoutingKey);
    }

    @Bean
    public MessageConverter JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setMessageConverter(JsonMessageConverter());
        return rabbitTemplate;
    }
}
*/
