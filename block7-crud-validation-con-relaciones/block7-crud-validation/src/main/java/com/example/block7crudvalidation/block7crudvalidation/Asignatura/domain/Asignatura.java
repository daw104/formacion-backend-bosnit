package com.example.block7crudvalidation.block7crudvalidation.Asignatura.domain;

import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_asignatura;

    @JsonIgnore
    @ManyToMany
    private List<Estudiante> estudiante = new ArrayList<>();


    @Column(name = "asignatura")
    private String asignatura;
    @Column(name = "comments")
    private String comments;
    @Column(name = "initial_date")
    @CreationTimestamp
    private Date initial_date;
    @Column(name = "finish_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finish_date;


}
