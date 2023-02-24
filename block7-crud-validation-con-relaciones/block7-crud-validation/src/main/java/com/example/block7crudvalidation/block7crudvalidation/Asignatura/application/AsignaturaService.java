package com.example.block7crudvalidation.block7crudvalidation.Asignatura.application;

import com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaFullOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaInputDto;
import com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request404;
import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request422;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsignaturaService {


    AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto);

    void deleteAsignaturaById(int id) throws Request404;


    AsignaturaOutputDto getAsignatura(int id, String outputType)throws Request404;


    Asignatura asignarEstudianteAsignatura(int idAsignatura, int idEstudiante) throws Request422;

    List<AsignaturaFullOutputDto> getAtllAsignaturas();





}
