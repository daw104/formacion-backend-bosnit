package com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto;

import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorSimpleOutputDto {

    int id_profesor;

    String coments;
    String branch;


    public ProfesorSimpleOutputDto(Profesor profesor){

        this.setId_profesor(profesor.getId_profesor());
        this.setComents(profesor.getComents());
        this.setBranch(profesor.getBranch());

    }

}
