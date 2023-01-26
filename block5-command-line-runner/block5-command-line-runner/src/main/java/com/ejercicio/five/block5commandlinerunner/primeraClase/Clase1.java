package com.ejercicio.five.block5commandlinerunner.primeraClase;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Clase1  {


    @PostConstruct
    private void primeraFuncion() {
        System.out.println("Hola desde clase inicial");
    }


//    Al ejecutar el programa, podemos observar que, antes de inicializer el servidor
//    primero se ejecuta la Clase Inicial, luego se inicializa el servidor y finalmente se
//    ejecutan la clase secundaria y la tercera

//    ¿Por que?
//    Porque cuando utilizamos la anotacion PostConstruct, se ejecuta despues de que el spring bean sea inicializado


}
