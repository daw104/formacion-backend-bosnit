package com.example.block7crudvalidation.block7crudvalidation.Profesor.application;

import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request404;
import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request422;
import com.example.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.example.block7crudvalidation.block7crudvalidation.Persona.repository.PersonaRepository;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorInputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorSimpleOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public ProfesorSimpleOutputDto updateProfesor(ProfesorInputDto profesor) throws Exception {

        Request404 request404 = new Request404("No existe el Profesor con el id " + profesor.getId_profesor());

        Profesor profesorExistente = profesorRepository.findById(profesor.getId_profesor())
                .orElseThrow(()->request404);


        if (profesor.getComents() != null) {
            profesorExistente.setComents(profesor.getComents());
        }

        if (profesor.getBranch() != null) {
            profesorExistente.setBranch(profesor.getBranch());
        }

        profesorRepository.save(profesorExistente);
        return new ProfesorSimpleOutputDto(profesorExistente);


    }


    
    
    @Override
    public ProfesorSimpleOutputDto getProfesorById(int id, String outputType) throws Request404 {

        switch (outputType) {
            case "full" -> {
                Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new Request404("no existe el Profesor con el id" + id));
                return new ProfesorOutputDto(profesor);
            }
            case "simple" -> {
                Profesor profesor1 = profesorRepository.findById(id).orElseThrow(() -> new Request404("no existe el Profesor con el id" + id));
                return new ProfesorSimpleOutputDto(profesor1);
            }
            default -> throw new Request422("Selecciona si quieres la informacion full o simple en el outputType");
        }

    }


    @Override
    public void deleteProfesorById(int id) throws Request404 {
        Request404 request404 = new Request404("No existe el profesor con el id " + id);
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
        } else {
            throw request404;
        }

    }


    @Override
    public List<ProfesorOutputDto> getAllProfesores() {

        List<ProfesorOutputDto> lista = new ArrayList<>();
        for (var p : profesorRepository.findAll()) {
            lista.add(new ProfesorOutputDto(p));
        }
        return lista;

    }

    @Override
   public ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto){
       Request404 request404 = new Request404("Esta persona ya es un profesor");

        Profesor profesor = new Profesor();

        Persona persona = personaRepository.findById(profesorInputDto.getPersona().getId_persona())
                .orElseThrow(() -> new Request404("No existe el la Persona con el id " + profesorInputDto.getPersona().getId_persona()) );

//       if(profesorRepository.existsById(profesorInputDto.getPersona().getId_persona())){

        if(persona.getProfesor() == null && persona.getEstudiante() == null){
            profesor.setPersona(personaRepository.findById(profesorInputDto.getPersona().getId_persona())
                    .orElseThrow(() -> new Request404("No existe el la Persona con el id " + profesorInputDto.getPersona().getId_persona()) ) );

            profesor.getPersona().setProfesor(profesor);
            profesor.setComents(profesorInputDto.getComents());
            profesor.setBranch(profesorInputDto.getBranch());

            profesorRepository.save(profesor);
//            personaRepository.save(profesorInputDto.getPersona());

            ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto(profesor);

            return profesorOutputDto;

        }else{

            throw request404;

        }

    }




}
