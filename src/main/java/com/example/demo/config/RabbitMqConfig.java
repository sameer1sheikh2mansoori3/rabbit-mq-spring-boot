package com.example.demo.config;


import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {


    @Value("${rabbitmq.queue.name}")
    private String queue;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing_key.name}")
    private String routingKey;

//    spring been for rabbit mq queue
    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

  @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }
//    binding between queue and exchange using rabbitmq key
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }
}
