package com.example.block7crud.block7crud.service;

import com.example.block7crud.block7crud.controller.dto.PersonaInputDto;
import com.example.block7crud.block7crud.controller.dto.PersonaOutputDto;
import com.example.block7crud.block7crud.model.Persona;
import com.example.block7crud.block7crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public PersonaOutputDto addPerson(PersonaInputDto person) {
        return personaRepository.save(new Persona(person))
                .personaToPersonaOutputDto();

    }

    //obtener persona por su id
    @Override
    public PersonaOutputDto getPersonById(int id) {
        return personaRepository.findById(id)
                .orElseThrow()
                .personaToPersonaOutputDto();
    }

    //obtener persona por su nombre
    @Override
    public List<Persona> getPersonPorNombre(String nombre) {
        List<Persona> personaExistente = personaRepository.findByNombre(nombre);
        return personaExistente;
    }

    @Override
    public void deletePersonById(int id) {
        personaRepository.findById(id).orElseThrow();
        personaRepository.deleteById(id);
    }

    //Todas las Personas
    @Override
    public ArrayList<Persona> getAllPersons() {
        return (ArrayList<Persona>) personaRepository.findAll();
    }

    //Personas paginadas
    @Override
    public List<PersonaOutputDto> getAllPersonsPaginadas(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return personaRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Persona::personaToPersonaOutputDto).toList();
    }


    @Override
    public PersonaOutputDto updatePerson(PersonaInputDto person) {
        personaRepository.findById(person.getId()).orElseThrow();
        return personaRepository.save(new Persona(person))
                .personaToPersonaOutputDto();
    }


    // Actualizar por id
    @Override
    public PersonaOutputDto updatePersonPorId(PersonaInputDto person) {
        Persona personaExistente = personaRepository.findById(person.getId()).get();

        if(person.getNombre()!=null){
        //averiguar que nombre tiene esa persona y dejarle como es
        personaExistente.setNombre(person.getNombre());
        }

        if(person.getEdad() !=0){
            personaExistente.setEdad(person.getEdad());
        }

        if(person.getPoblacion()!=null){
            //averiguar que nombre tiene esa persona y dejarle como es
            personaExistente.setPoblacion(person.getPoblacion());
        }

        Persona personaActualizada = personaRepository.save(personaExistente);

        return personaActualizada.personaToPersonaOutputDto();

    }




}