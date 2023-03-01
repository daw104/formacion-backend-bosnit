package com.example.block12kafka.demo.kafka;

import com.example.block12kafka.demo.models.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    //eL KAFKA LISTENER LO QUE HACE ES QUE SE PONE A ESCUHAR EN ESE TOPICO Y EN GROUP_ID
    @KafkaListener(topics = "Topic1_json", groupId = "myGroup")
    //Esto convertira el objeto Persona JSON a un Objeto Java Persona
    public void  consume(Persona persona){
            LOGGER.info(String.format("JSON Mensaje recivido -> %s", persona.toString()));
    }


}
