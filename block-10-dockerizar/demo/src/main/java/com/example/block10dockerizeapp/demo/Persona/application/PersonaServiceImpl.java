package com.example.block10dockerizeapp.demo.Persona.application;


import com.example.block10dockerizeapp.demo.Persona.Errors.Request404;
import com.example.block10dockerizeapp.demo.Persona.Errors.Request422;
import com.example.block10dockerizeapp.demo.Persona.controller.dto.PersonaInputDto;
import com.example.block10dockerizeapp.demo.Persona.controller.dto.PersonaOutputDto;

import com.example.block10dockerizeapp.demo.Persona.domain.Persona;
import com.example.block10dockerizeapp.demo.Persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {


    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto addPerson(PersonaInputDto inputDtoPersona) throws Exception {

            if(inputDtoPersona.getUsuario().length() < 6 || inputDtoPersona.getUsuario().length() > 10){
                throw new Request422(("La longitud del campo usuario tiene que ser entrea 6 y 10 caracteres"));

            }

        if(inputDtoPersona.getUsuario() == null || inputDtoPersona.getUsuario().isEmpty()){
            throw new Request422(("El campo usuario no puede ser nulo"));
        }

        if(inputDtoPersona.getPassword() == null || inputDtoPersona.getPassword().isEmpty()){
            throw new Request422(("El campo password no puede ser nulo"));
        }
        if(inputDtoPersona.getName() == null || inputDtoPersona.getName().isEmpty()){
            throw new Request422(("El campo nombre no puede ser nulo"));
        }
        if(inputDtoPersona.getCompany_email() == null || inputDtoPersona.getCompany_email().isEmpty()){
            throw new Request422(("El campo Company_email no puede ser nulo"));
        }
        if(inputDtoPersona.getPersonal_email() == null || inputDtoPersona.getPersonal_email().isEmpty()){
            throw new Request422(("El campo Personal_email no puede ser nulo"));
        }
        if(inputDtoPersona.getCity() == null || inputDtoPersona.getCity().isEmpty()){
            throw new Request422(("El campo ciudad no puede ser nulo"));
        }

        return new PersonaOutputDto(personaRepository.save(inputDtoPersona.inputDtoPersona()));

    }

    //Motsrar todas las personas
    @Override
    public List<PersonaOutputDto> getAllPersons(){
        List<PersonaOutputDto> lista = new ArrayList<>();
        for (var p: personaRepository.findAll()){
            lista.add(new PersonaOutputDto(p));
        }

        return lista;

    }



    @Override
    public PersonaOutputDto getPersonById(int id) throws Request404 {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new Request404("\nNo existe la persona con el id " + id) );
        PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);
        return personaOutputDto;
    }




    //eliminar persona por ID
    @Override
    public void  deletePersonById(int id) throws Request404{
        Request404 request404 = new Request404("No existe la persona con el id " + id);
        if(personaRepository.existsById(id)){
            personaRepository.deleteById(id);
        }else{
           throw request404;
        }

    }

    //Actualizar persona por id
    public PersonaOutputDto updatePersonPorId(PersonaInputDto person) throws Exception{

        Request404 request404 = new Request404("No existe la persona con el id " + person.getId_persona());


            if(personaRepository.existsById(person.getId_persona())){

                Persona personExistente = personaRepository.findById(person.getId_persona()).get();

                    if(person.getUsuario() == null || person.getUsuario().isEmpty()){
                            throw new Request422(("El campo usuario no puede ser nulo"));
                    }
                    if((person.getUsuario().length() < 6 || person.getUsuario().length()>10)){
                        throw new Request422(("La longitud del campo usuario tiene que ser entrea 6 y 10 caracteres"));
                    }

                    if(person.getPassword() == null || person.getPassword().isEmpty()){
                        throw new Request422(("El campo password no puede ser nulo"));
                    }
                    if(person.getName() == null || person.getName().isEmpty()){
                        throw new Request422(("El campo nombre no puede ser nulo"));
                    }
                    if(person.getCompany_email() == null || person.getCompany_email().isEmpty()){
                        throw new Request422(("El campo Company_email no puede ser nulo"));
                    }
                    if(person.getPersonal_email() == null || person.getPersonal_email().isEmpty()){
                        throw new Request422(("El campo Personal_email no puede ser nulo"));
                    }
                    if(person.getCity() == null || person.getCity().isEmpty()){
                        throw new Request422(("El campo ciudad no puede ser nulo"));
                    }



                if(person.getUsuario()!=null){
                    //averiguar que nombre tiene esa persona y dejarle como es
                    personExistente.setUsuario(person.getUsuario());
                }
                if(person.getName()!=null){
                    //averiguar que nombre tiene esa persona y dejarle como es
                    personExistente.setName(person.getName());
                }

                if(person.getPassword()!=null){
                    //averiguar que nombre tiene esa persona y dejarle como es
                    personExistente.setPassword(person.getPassword());
                }

                if(person.getSurname()!=null){
                    //averiguar que nombre tiene esa persona y dejarle como es
                    personExistente.setSurname(person.getSurname());
                }
                if(person.getCompany_email()!=null){
                    //averiguar que nombre tiene esa persona y dejarle como es
                    personExistente.setCompany_email(person.getCompany_email());
                }
                if(person.getPersonal_email()!=null){
                    //averiguar que nombre tiene esa persona y dejarle como es
                    personExistente.setPersonal_email(person.getPersonal_email());
                }
                if(person.getCity()!=null){
                    //averiguar que nombre tiene esa persona y dejarle como es
                    personExistente.setCity(person.getCity());
                }

                personExistente.setActive(person.isActive());

                if(person.getImagen_url()!=null){
                    //averiguar que nombre tiene esa persona y dejarle como es
                    personExistente.setImagen_url(person.getImagen_url());
                }
                if(person.getTermination_date()!=null){
                    //averiguar que nombre tiene esa persona y dejarle como es
                    personExistente.setTermination_date(person.getTermination_date());
                }

                personaRepository.save(personExistente);

                return new PersonaOutputDto(personExistente);

            }else{
                throw request404;
            }

    }


}
