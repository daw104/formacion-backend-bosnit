package com.example.block11uploaddownloadfiles.demo.Files.Erros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class HandlerExcepciones {

    @ExceptionHandler(Request404.class)
    public ResponseEntity<Object> handlerError(Request404 request404) {
        CustomErros customError = new CustomErros(new Date(), 404, request404.getMessage());
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Request422.class)
    public ResponseEntity<Object> handlerError(Request422 request422) {
        CustomErros customError = new CustomErros(new Date(), 422, request422.getMessage());
        return new ResponseEntity<>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
