package com.example.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaSampleProducerController {

    private final KafkaSampleProducerService kafkaSampleProducerService;

    @PostMapping(value = "/sendMessage")
    public void sendMessage(String message) {
        kafkaSampleProducerService.sendMessage(message);
    }
}
