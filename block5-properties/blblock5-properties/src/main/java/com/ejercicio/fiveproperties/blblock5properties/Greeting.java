package com.ejercicio.fiveproperties.blblock5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Greeting implements CommandLineRunner {

    @Value("${greeting}")
    private String greeting;

    //valor de gretting
    @Override
    public void run(String... args) throws Exception {
        System.out.println("El valor de greeting es: " + greeting );
    }


}
