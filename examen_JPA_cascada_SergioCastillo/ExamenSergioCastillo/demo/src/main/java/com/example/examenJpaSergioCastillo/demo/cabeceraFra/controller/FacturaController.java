package com.example.examenJpaSergioCastillo.demo.cabeceraFra.controller;

import com.example.examenJpaSergioCastillo.demo.Errors.Request404;
import com.example.examenJpaSergioCastillo.demo.cabeceraFra.application.CabeceraFacturaImpl;
import com.example.examenJpaSergioCastillo.demo.cabeceraFra.controller.dto.FacturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    CabeceraFacturaImpl cabeceraFacturaService;


    @GetMapping("/get")
    public Iterable<FacturaOutputDto> getFacturas() {
        return cabeceraFacturaService.getFacturas();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFactura(@PathVariable("id") int id) throws Request404 {
        cabeceraFacturaService.deleteFactura(id);
        return new ResponseEntity<>("Factura con el id " + id + " eliminada", HttpStatus.OK);
    }


}
