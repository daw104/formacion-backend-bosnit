package com.example.examenJpaSergioCastillo.demo.lineasFra.controller.dto;

import com.example.examenJpaSergioCastillo.demo.cabeceraFra.domain.CabeceraFra;
import com.example.examenJpaSergioCastillo.demo.cliente.domain.Cliente;
import com.example.examenJpaSergioCastillo.demo.lineasFra.domain.LineaFra;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LineaFacturaOutputDto {

    int id;

    String producto;

    double cantidad;

    double precio;


    public LineaFacturaOutputDto(LineaFra lineaFra){

        this.setId(lineaFra.getId());
        this.setProducto(lineaFra.getProNomb());
        this.setCantidad(lineaFra.getCantidad());
        this.setPrecio(lineaFra.getPrecio());
    }


}
