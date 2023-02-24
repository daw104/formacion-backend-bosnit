package com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto;

import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.example.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteSimpleOutputDto {


    int id_student;
    int num_hours_week;
    String coments;
    String branch;


    public EstudianteSimpleOutputDto(Estudiante estudiante){

        this.setId_student(estudiante.getId_student());
        this.setNum_hours_week(estudiante.getNum_hours_week());
        this.setComents(estudiante.getComents());
        this.setBranch(estudiante.getBranch());

    }



}
