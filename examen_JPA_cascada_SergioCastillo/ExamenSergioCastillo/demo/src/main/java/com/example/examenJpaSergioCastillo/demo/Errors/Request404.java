package com.example.examenJpaSergioCastillo.demo.Errors;

public class Request404 extends RuntimeException{
    public Request404(String message) {
        super(message);
    }
}
