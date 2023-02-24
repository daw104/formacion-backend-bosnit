package com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto;

import com.example.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProfesorInputDto {


    int id_profesor;
    Persona  persona;
    String coments;
    String branch;

    public Profesor inputDtoProfesor(){
        Profesor profesorInput = new Profesor();

        profesorInput.setId_profesor(this.id_profesor);
        profesorInput.setPersona(this.persona);
        profesorInput.setComents(this.coments);
        profesorInput.setBranch(this.branch);

        return profesorInput;

    }




}
