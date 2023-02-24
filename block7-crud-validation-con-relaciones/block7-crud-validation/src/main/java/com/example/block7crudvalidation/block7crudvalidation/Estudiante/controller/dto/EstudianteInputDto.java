package com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto;

import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.example.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteInputDto {

    int id_student;
    Persona persona;

//    int id_persona;
    Profesor profesor;

    int num_hours_week;
    String coments;
    String branch;

    public Estudiante inputDtoEstudiante() {
        Estudiante estudianteInput = new Estudiante();

        estudianteInput.setId_student(this.id_student);
        estudianteInput.setPersona(this.persona);
        estudianteInput.setProfesor(this.profesor);
        estudianteInput.setNum_hours_week(this.num_hours_week);
        estudianteInput.setComents(this.coments);
        estudianteInput.setBranch(this.branch);

        return estudianteInput;
    }



}
