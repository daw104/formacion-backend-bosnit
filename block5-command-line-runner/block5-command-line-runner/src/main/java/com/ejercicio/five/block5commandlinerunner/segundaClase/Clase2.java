package com.ejercicio.five.block5commandlinerunner.segundaClase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Clase2 implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola desde clase secundaria");
    }
}
