package com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto;

import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.example.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteOutputDto extends EstudianteSimpleOutputDto {

    //Full Output donde mostramos los datos adicionales del estudiante
    PersonaOutputDto personaOutputDto;

    ProfesorOutputDto profesorOutputDto;

    public EstudianteOutputDto(Estudiante estudiante){
        super(estudiante);
        this.setPersonaOutputDto(new PersonaOutputDto(estudiante.getPersona())); //devuelvo persona
        this.setProfesorOutputDto(new ProfesorOutputDto(estudiante.getProfesor()));//devuelvo profesor

    }



}
