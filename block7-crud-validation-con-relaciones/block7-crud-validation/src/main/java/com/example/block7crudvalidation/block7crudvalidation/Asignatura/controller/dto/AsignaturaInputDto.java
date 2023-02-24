package com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto;


import com.example.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaInputDto {


    int id_asignatura;

    String asignatura;

    String comments;

    Date initial_date;

    Date finish_date;


    public Asignatura inputDtoAsignatura(){
        Asignatura asignaturaInput = new Asignatura();

        asignaturaInput.setAsignatura(this.asignatura);
        asignaturaInput.setComments(this.comments);
        asignaturaInput.setInitial_date(this.initial_date);
        asignaturaInput.setFinish_date(this.finish_date);

        return asignaturaInput;
    }


}
