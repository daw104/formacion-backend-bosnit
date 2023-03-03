package com.example.examenJpaSergioCastillo.demo.Errors;

import java.util.Date;

public class Request422 extends RuntimeException{
    public Request422(String message) {
        super(message);
    }
}
