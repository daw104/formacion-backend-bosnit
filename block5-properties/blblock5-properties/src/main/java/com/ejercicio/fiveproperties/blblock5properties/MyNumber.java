package com.ejercicio.fiveproperties.blblock5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyNumber implements CommandLineRunner {

    @Value("${my.number}")
    String myNymber;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("El valor de my.number es: " + myNymber);
    }
}
