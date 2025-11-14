package com.example.demo.controller;

import com.example.demo.dto.User;
import com.example.demo.producer.RabbitMqJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
    private RabbitMqJsonProducer jsonProducer;
    public MessageJsonController(RabbitMqJsonProducer rabbitMqJsonProducer) {
        this.jsonProducer = rabbitMqJsonProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String>sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to rabbit mq...");

    }


}
