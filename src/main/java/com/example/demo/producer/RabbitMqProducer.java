package com.example.demo.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {


//    exchange name
@Value("${rabbitmq.exchange.name}")
private String exchane;

    //    routing key
    @Value("${rabbitmq.routing_key.name}")
    private String routing_key;
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducer.class);

    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitMqProducer(RabbitTemplate rabbitTemplate){
          this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent -> %s", message));
        this.rabbitTemplate.convertAndSend(exchane, routing_key, message);
    }
}
