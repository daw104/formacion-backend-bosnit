package com.example.block6personcontrollers.block6personcontrollers.services;

import com.example.block6personcontrollers.block6personcontrollers.models.Person;
import org.springframework.stereotype.Service;

@Service
public class ServicePerson {


    private Person person1;

    public Person crearPersona(String nombre, String poblacion, int edad){
        person1 = new Person(nombre, poblacion, edad);
        return person1;
    }
}












