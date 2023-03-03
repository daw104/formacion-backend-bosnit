package com.example.block12kafka.demo.controllers;

import com.example.block12kafka.demo.kafka.JsonKafkaProducer;
import com.example.block12kafka.demo.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish/persona")
    public ResponseEntity<Persona> publishPersona(@RequestBody  Persona persona){
        jsonKafkaProducer.sendMessage(persona);
        return ResponseEntity.ok(persona);
    }



}
