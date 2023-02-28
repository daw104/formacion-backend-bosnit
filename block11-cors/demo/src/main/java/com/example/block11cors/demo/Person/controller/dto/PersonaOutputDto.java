package com.example.block11cors.demo.Person.controller.dto;

import com.example.block11cors.demo.Person.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDto {

    int id_persona;
    String usuario;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    boolean active;
    Date created_date;
    String  imagen_url;
    Date  termination_date;


    public PersonaOutputDto(Persona persona){

        this.setId_persona(persona.getId_persona());
        this.setUsuario(persona.getUsuario());
        this.setName(persona.getName());
        this.setSurname(persona.getSurname());
        this.setCompany_email(persona.getCompany_email());
        this.setPersonal_email(persona.getPersonal_email());
        this.setCity(persona.getCity());
        this.setActive(persona.isActive());
        this.setCreated_date(persona.getCreated_date());
        this.setImagen_url(persona.getImagen_url());
        this.setTermination_date(persona.getTermination_date());

    }


}
