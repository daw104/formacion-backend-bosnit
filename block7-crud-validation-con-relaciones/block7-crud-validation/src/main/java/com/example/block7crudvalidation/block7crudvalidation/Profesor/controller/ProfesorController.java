package com.example.block7crudvalidation.block7crudvalidation.Profesor.controller;

import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request404;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.application.ProfesorServiceImpl;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorInputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorSimpleOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    ProfesorServiceImpl profesorService;


    @PutMapping("/update/{id}")
    public ResponseEntity<ProfesorSimpleOutputDto> updateProfesor(@PathVariable ("id") int id, @RequestBody ProfesorInputDto profesor) throws Exception{
            profesor.setId_profesor(id);
            return new ResponseEntity<>(profesorService.updateProfesor(profesor), HttpStatus.OK);
    }




    @GetMapping("/get/{id}")
    public ProfesorSimpleOutputDto getProfesorById(@PathVariable ("id") int id, @RequestParam String outputType){
        return profesorService.getProfesorById(id, outputType);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProfesorById(@PathVariable ("id") int id) throws Request404 {
        profesorService.deleteProfesorById(id);
        return new ResponseEntity<>("Profesor con el id " + id + " eliminado", HttpStatus.OK);
    }


    @GetMapping("/get-all-profesores")
    public Iterable<ProfesorOutputDto> getAllProfesores() {
        return profesorService.getAllProfesores();
    }


    @PostMapping("/add")
    public ResponseEntity<ProfesorOutputDto> addProfesor(@RequestBody ProfesorInputDto profesorInputDto) throws Exception{
        return  new ResponseEntity<>(profesorService.addProfesor(profesorInputDto), HttpStatus.OK);
    }

}
