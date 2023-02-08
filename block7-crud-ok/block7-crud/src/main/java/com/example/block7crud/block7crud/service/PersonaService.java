package com.example.block7crud.block7crud.service;

import com.example.block7crud.block7crud.controller.dto.PersonaInputDto;
import com.example.block7crud.block7crud.controller.dto.PersonaOutputDto;
import com.example.block7crud.block7crud.model.Persona;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public interface PersonaService {

    //AÑADIR persona
    PersonaOutputDto addPerson(PersonaInputDto person);

    //Persona por id
    PersonaOutputDto getPersonById(int id);

    //    //Eliminar persona
    void deletePersonById(int id);

    //    //todas las personas
    ArrayList<Persona> getAllPersons();

    //    //personas paginadas
    Iterable<PersonaOutputDto> getAllPersonsPaginadas(int pageNumber, int pageSize);

    //    //actualizar persona
    PersonaOutputDto updatePerson(PersonaInputDto person);

    //Actualizar persona por Id
    PersonaOutputDto updatePersonPorId(PersonaInputDto person);

    //Consultar persona por nombre
    List<Persona> getPersonPorNombre(String nombre);

}
