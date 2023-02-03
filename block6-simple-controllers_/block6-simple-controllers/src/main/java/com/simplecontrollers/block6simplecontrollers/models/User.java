package com.simplecontrollers.block6simplecontrollers.models;

import lombok.*;

// con lombok te genera getters, setters
@AllArgsConstructor // esto construye el constructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private String nombre;
    private String poblacion;
    private int edad;


    @Override
    public String toString() {
        return "User{" +
                "nombre='" + nombre + '\'' +
                ", poblacion='" + poblacion + '\'' +
                ", edad=" + edad +
                '}';
    }

}




