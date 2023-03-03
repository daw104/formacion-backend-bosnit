package com.example.examenJpaSergioCastillo.demo.lineasFra.controller;

import com.example.examenJpaSergioCastillo.demo.Errors.Request404;
import com.example.examenJpaSergioCastillo.demo.cabeceraFra.controller.dto.FacturaOutputDto;
import com.example.examenJpaSergioCastillo.demo.lineasFra.application.LineaFacturaServiceImpl;
import com.example.examenJpaSergioCastillo.demo.lineasFra.controller.dto.LineaFacturaInputDto;
import com.example.examenJpaSergioCastillo.demo.lineasFra.repository.LineaFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
public class LineaController {

    @Autowired
    LineaFacturaServiceImpl lineaFacturaService;

    @PostMapping("/linea/{id}")
    public ResponseEntity<FacturaOutputDto> addLinea(@RequestBody LineaFacturaInputDto lineaFacturaInputDto, @PathVariable("id") int id) throws Request404 {
        return new ResponseEntity<>(lineaFacturaService.addLinea(lineaFacturaInputDto, id), HttpStatus.OK);

    }


}
