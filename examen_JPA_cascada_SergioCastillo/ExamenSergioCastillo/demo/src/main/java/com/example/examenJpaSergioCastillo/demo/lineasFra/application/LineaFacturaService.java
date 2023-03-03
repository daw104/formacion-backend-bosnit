package com.example.examenJpaSergioCastillo.demo.lineasFra.application;

import com.example.examenJpaSergioCastillo.demo.cabeceraFra.controller.dto.FacturaOutputDto;
import com.example.examenJpaSergioCastillo.demo.lineasFra.controller.dto.LineaFacturaInputDto;
import com.example.examenJpaSergioCastillo.demo.lineasFra.controller.dto.LineaFacturaOutputDto;
import org.springframework.stereotype.Service;

@Service
public interface LineaFacturaService {

    //añadir lineas a una factura ya existente, arroja 404 si no encuentra la factura
    FacturaOutputDto addLinea(LineaFacturaInputDto lineaFacturaInputDto, int id);

}
