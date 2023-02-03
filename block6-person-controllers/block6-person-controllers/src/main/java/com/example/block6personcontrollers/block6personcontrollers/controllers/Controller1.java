package com.example.block6personcontrollers.block6personcontrollers.controllers;

import com.example.block6personcontrollers.block6personcontrollers.models.Ciudad;
import com.example.block6personcontrollers.block6personcontrollers.services.CiudadService;
import com.example.block6personcontrollers.block6personcontrollers.models.Person;
import com.example.block6personcontrollers.block6personcontrollers.services.ServicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controlador1")
public class Controller1 {

    @Autowired
    ServicePerson serviceperson;

    @Autowired
    CiudadService ciudadService;

    @GetMapping(value = "/addPersona")
    public Person addPersona(@RequestHeader("nombre") String nombre, @RequestHeader("poblacion") String poblacion, @RequestHeader("edad") int edad) {
        Person persona= new Person();
        persona= serviceperson.crearPersona(nombre, poblacion, edad);
        return persona;
    }


    @PostMapping("/addCiudad")
    public String addCiudad(@RequestBody Ciudad ciudad){
         return  ciudadService.addCiudades(ciudad);
    }


}
