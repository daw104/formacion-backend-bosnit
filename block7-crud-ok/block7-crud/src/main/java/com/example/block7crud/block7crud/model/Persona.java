package com.example.block7crud.block7crud.model;

import com.example.block7crud.block7crud.controller.dto.PersonaInputDto;
import com.example.block7crud.block7crud.controller.dto.PersonaOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue
    int id;
   String nombre;
   int edad;
   String  poblacion;

    //Metodos para transformar dtos en objetos de clase student
    public Persona(PersonaInputDto personaInputDto){
        this.id = personaInputDto.getId();
        this.nombre = personaInputDto.getNombre();
        this.edad = personaInputDto.getEdad();
        this.poblacion = personaInputDto.getPoblacion();
    }


    public PersonaOutputDto personaToPersonaOutputDto(){
        return new PersonaOutputDto(
                this.id,
                this.nombre,
                this.edad,
                this.poblacion
        );
    }



}
