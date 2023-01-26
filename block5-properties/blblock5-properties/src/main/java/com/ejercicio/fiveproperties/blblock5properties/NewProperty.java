package com.ejercicio.fiveproperties.blblock5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class NewProperty implements CommandLineRunner {

    @Value("${new.property:new.property no tiene valor}")
    private String newProperty;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("El valor de new.property es: " +  newProperty );
    }
}
