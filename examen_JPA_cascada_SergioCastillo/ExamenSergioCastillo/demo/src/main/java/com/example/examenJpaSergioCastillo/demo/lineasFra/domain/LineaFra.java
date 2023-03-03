package com.example.examenJpaSergioCastillo.demo.lineasFra.domain;

import com.example.examenJpaSergioCastillo.demo.Errors.Request422;
import com.example.examenJpaSergioCastillo.demo.cabeceraFra.domain.CabeceraFra;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lineaFra")
public class LineaFra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String proNomb;

    private double cantidad;
    private double precio;

    //relacion 1-n con las lineas de factura
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFra")
    @JsonBackReference
    private CabeceraFra cabeceraFra;

    //constructor para poder inicializar las lineas cuando arranque la aplicacion
    public LineaFra(String proNomb, double cantidad, double precio, CabeceraFra cabeceraFra) {
        if(proNomb.isBlank() || proNomb.isBlank()){
            throw new Request422("El producto no puede estar vacio");
        }
        this.proNomb = proNomb;
        this.cantidad = cantidad;
        this.precio = precio;
        this.cabeceraFra = cabeceraFra;
    }

}




