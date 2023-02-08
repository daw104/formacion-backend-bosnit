package com.example.block7crud.block7crud.controller.dto;

import com.example.block7crud.block7crud.model.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDto {

    private int id;
    String nombre;
    int edad;
    String poblacion;




}
