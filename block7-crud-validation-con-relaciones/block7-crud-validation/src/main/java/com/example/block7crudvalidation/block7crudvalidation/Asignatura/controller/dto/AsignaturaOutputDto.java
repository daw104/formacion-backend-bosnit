package com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto;

import com.example.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDto {

    int id_asignatura;
    String asignatura;
    String comments;
    Date initial_date;
    Date finish_date;

    public AsignaturaOutputDto(Asignatura asignatura){
        this.setId_asignatura(asignatura.getId_asignatura());
        this.setAsignatura(asignatura.getAsignatura());
        this.setComments(asignatura.getComments());
        this.setInitial_date(asignatura.getInitial_date());
        this.setFinish_date(asignatura.getFinish_date());


    }



}
