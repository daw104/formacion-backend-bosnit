package com.example.block11cors.demo.Person.controller.dto;

import com.example.block11cors.demo.Person.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaInputDto {

    int id_persona;
    String usuario;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    boolean active;
    Date created_date;
    String  imagen_url;
    Date  termination_date;


    //Metodos para transformar dtos en objetos de clase student
    public Persona inputDtoPersona(){
        Persona personaInput = new Persona();

        personaInput.setId_persona(this.getId_persona());
        personaInput.setUsuario(this.getUsuario());
        personaInput.setPassword(this.getPassword());
        personaInput.setName(this.getName());
        personaInput.setSurname(this.getSurname());
        personaInput.setCompany_email(this.getCompany_email());
        personaInput.setPersonal_email(this.getPersonal_email());
        personaInput.setCity(this.getCity());
        personaInput.setActive(this.isActive());
        personaInput.setCreated_date(this.getCreated_date());
        personaInput.setImagen_url(this.getImagen_url());
        personaInput.setTermination_date(this.getTermination_date());

        return personaInput;
    }
}
