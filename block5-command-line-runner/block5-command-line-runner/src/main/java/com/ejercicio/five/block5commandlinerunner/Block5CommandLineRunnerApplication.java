package com.ejercicio.five.block5commandlinerunner;

import com.ejercicio.five.block5commandlinerunner.primeraClase.Clase1;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
            System.out.println("Soy la tercera clase y me ejecuto cuando se ejecuta el programa");
	}
}
