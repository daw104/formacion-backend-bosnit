package com.example.block12kafka.demo.kafka;

import com.example.block12kafka.demo.models.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, Persona>  kafkaTemplate;

    //constructor
    public JsonKafkaProducer(KafkaTemplate<String, Persona> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //Construimos el mensaje
    public void sendMessage(Persona  persona){
        LOGGER.info(String.format("JSON Enviado -> %s", persona.toString()));
        Message<Persona> message = MessageBuilder
                .withPayload(persona)
                .setHeader(KafkaHeaders.TOPIC, "Topic1_json")
                .build();
        kafkaTemplate.send(message);
    }

}
