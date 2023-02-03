package com.example.block6pathvariableheaders.block6pathvariableheaders.controllers;

import com.example.block6pathvariableheaders.block6pathvariableheaders.models.Greeting;
import com.example.block6pathvariableheaders.block6pathvariableheaders.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //Saludar con el parametro que viene
    @GetMapping("/greeting")//el default value es por si el nombre que estamos esperando no viene, ponga por defecto World
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting();
        greeting.setId(counter.incrementAndGet());
        greeting.setContent(String.format(template,name));
        return greeting;
    }




}
