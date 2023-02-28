package com.example.block11cors.demo.Person.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id_persona;

    @Column(nullable = false)
//    @Size( min = 6, max = 10)
    String usuario;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String name;

    String surname;
    @Column(nullable = false)
    String company_email;

    @Column(nullable = false)
    String personal_email;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    boolean active;


    @Column(nullable = false)
    @CreationTimestamp
    Date created_date;

    String  imagen_url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date  termination_date;

}
