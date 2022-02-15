package com.raniket.jmsdemo.demo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public TestController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
        Msg msg = new Msg();
        msg.setName("Raniket");
        msg.setAge(27);
        msg.setIsMarried(false);
        kafkaTemplate.send("test-topic", msg.toString());
        return "Hello World";
    }
}