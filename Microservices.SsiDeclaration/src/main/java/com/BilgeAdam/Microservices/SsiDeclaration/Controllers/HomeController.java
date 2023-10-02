package com.BilgeAdam.Microservices.SsiDeclaration.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    // Buradan kafka ile payrolla mesaj yollanır
    @GetMapping("test/{mesaj}")
    public String sendMessage(@PathVariable("mesaj") String mesaj) {
        kafkaTemplate.send("topic1", mesaj);
        return "test";
    }
    // Payrolldan bu endpointe istek atılıyor
    @GetMapping("test")
    public String test(){
        return "ssi declarationdan dönen cevap";
    }
}
