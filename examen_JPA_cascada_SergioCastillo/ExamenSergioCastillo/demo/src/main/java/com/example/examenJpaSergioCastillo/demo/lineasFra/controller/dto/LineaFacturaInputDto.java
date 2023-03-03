package com.example.examenJpaSergioCastillo.demo.lineasFra.controller.dto;

import com.example.examenJpaSergioCastillo.demo.cabeceraFra.domain.CabeceraFra;
import com.example.examenJpaSergioCastillo.demo.lineasFra.domain.LineaFra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LineaFacturaInputDto {

    CabeceraFra factura;

    String producto;

    double cantidad;

    double precio;


    public LineaFra LineaFacturaInputDto(){
        LineaFra lineaFraInput = new LineaFra();

        lineaFraInput.setProNomb(this.producto);
        lineaFraInput.setCantidad(this.cantidad);
        lineaFraInput.setPrecio(this.precio);
        lineaFraInput.setCabeceraFra(this.factura);

        return lineaFraInput;
    }


}
