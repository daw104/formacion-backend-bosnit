package com.simplecontrollers.block6simplecontrollers.controllers;

import com.simplecontrollers.block6simplecontrollers.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @GetMapping(value= "user/{nombre}")
    public String getUser(@PathVariable String nombre){
        return "Hola " + nombre;
    }


//, consumes = "aplication/json"
    @PostMapping( value= "user/adduser")
    public User addUser(@RequestBody User user){
        user.setNombre(user.getNombre());
        user.setPoblacion(user.getPoblacion());
        user.setEdad(user.getEdad() + 1);
        return user;

    }



}
