package com.example.block10dockerizeapp.demo.Persona.application;



import com.example.block10dockerizeapp.demo.Persona.Errors.Request404;
import com.example.block10dockerizeapp.demo.Persona.controller.dto.PersonaInputDto;
import com.example.block10dockerizeapp.demo.Persona.controller.dto.PersonaOutputDto;
import com.example.block10dockerizeapp.demo.Persona.domain.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {

    //AÑADIR persona
    PersonaOutputDto addPerson(PersonaInputDto person) throws Exception;

    //Mostrar todos las personas
    List<PersonaOutputDto> getAllPersons();



    //Mostrar persona por Id
    PersonaOutputDto getPersonById(int id) throws Request404;

    //Borrar persona por Id
    void deletePersonById(int id) throws Request404;


    //actualizar persona por id
    PersonaOutputDto updatePersonPorId(PersonaInputDto person) throws Exception;



}
