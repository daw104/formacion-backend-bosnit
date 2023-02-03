package com.simplecontrollers.block6simplecontrollers.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    @GetMapping(value="/ok")
    public ResponseEntity<String> ok(){
        return new ResponseEntity<>(HttpStatus.OK + " : Respusta correcto", HttpStatus.OK);
    }

    @GetMapping(value="/notfound")
    public ResponseEntity<String> notFound(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND + ": Recurso no encontrado", HttpStatus.NOT_FOUND);
    }




}
