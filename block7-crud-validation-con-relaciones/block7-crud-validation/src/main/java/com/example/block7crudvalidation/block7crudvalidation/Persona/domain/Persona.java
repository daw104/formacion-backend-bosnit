package com.example.block7crudvalidation.block7crudvalidation.Persona.domain;

import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
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
    private int id_persona;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    private String surname;
    @Column(nullable = false)
    private String company_email;

    @Column(nullable = false)
    private String personal_email;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private boolean active;


    @Column(nullable = false)
    @CreationTimestamp
    private Date created_date;

    private String imagen_url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date termination_date;

    @OneToOne(mappedBy = "persona")
    private Estudiante estudiante;

    @OneToOne(mappedBy = "persona")
    private Profesor profesor;


}
