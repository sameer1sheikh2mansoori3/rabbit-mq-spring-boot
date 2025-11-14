package com.example.demo.producer;

import com.example.demo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonProducer {

    @Value("${rabbitmq.exchange.json.name}")
    private String exchange;
    @Value("${rabbitmq.routing_key.json}")
    private String routingKeyJson;
    private RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonProducer.class);

    public RabbitMqJsonProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendJsonMessage(User user){
        LOGGER.info(String.format("JSON Message sent -> %s", user.toString()));
        this.rabbitTemplate.convertAndSend(exchange, routingKeyJson, user);
    }

}
