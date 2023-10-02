package com.BilgeAdam.Microservices.Payroll.Kafka.Listeners;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@EnableKafka
@Component
public class SsiDeclarationListener {
    @KafkaListener(topics = "topic1",groupId = "myGroup")
    void listener(String data) {
        System.out.println(data);
    }
}
