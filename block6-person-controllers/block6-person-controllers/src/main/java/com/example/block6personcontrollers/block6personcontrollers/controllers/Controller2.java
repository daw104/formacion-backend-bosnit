package com.example.block6personcontrollers.block6personcontrollers.controllers;

import com.example.block6personcontrollers.block6personcontrollers.models.Ciudad;
import com.example.block6personcontrollers.block6personcontrollers.services.CiudadService;
import com.example.block6personcontrollers.block6personcontrollers.models.Person;
import com.example.block6personcontrollers.block6personcontrollers.services.ServicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controlador2")
public class Controller2 {

    @Autowired
    Controller1 controller1;

    @Autowired
    CiudadService ciudadService;


    @GetMapping(value = "/getPersona")
    public Person getPersona(@RequestHeader("nombre") String nombre, @RequestHeader("poblacion") String poblacion, @RequestHeader("edad") int edad) {
        Person persona= new Person();

        persona= controller1.addPersona(nombre, poblacion, edad * 2);

        return persona;
    }


    @GetMapping(value = "/getCiudades")
    public List<Ciudad> getAllciudades(){
        return ciudadService.getAllciudades();
    }


}

