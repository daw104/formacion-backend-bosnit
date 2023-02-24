package com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto;

import com.example.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDto extends ProfesorSimpleOutputDto {

    //Full Output donde mostramos los datos adicionales del estudiante

    PersonaOutputDto personaOutputDto;

    public ProfesorOutputDto(Profesor profesor){
        super(profesor);
        this.setPersonaOutputDto(new PersonaOutputDto(profesor.getPersona()));
    }





}
