package com.example.block7crudvalidation.block7crudvalidation.Profesor.application;

import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request404;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorInputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorSimpleOutputDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfesorService {

    ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto);

    List<ProfesorOutputDto> getAllProfesores();

    void deleteProfesorById(int id) throws Request404;

    ProfesorSimpleOutputDto getProfesorById(int id, String outputType) throws Request404;

    ProfesorSimpleOutputDto updateProfesor(ProfesorInputDto profesor) throws Exception;



}
