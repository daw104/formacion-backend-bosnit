package com.example.block12kafka.demo.models;

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
    private int id;

    private String usuario;

    private String password;

    private String name;

    private String company_email;

    private String personal_email;

    private String city;

    private boolean active;

    @CreationTimestamp
    private Date created_date;

    private String imagen_url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date termination_date;

}
