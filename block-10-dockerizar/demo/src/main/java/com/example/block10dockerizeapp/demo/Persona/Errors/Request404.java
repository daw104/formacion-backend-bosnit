package com.example.block10dockerizeapp.demo.Persona.Errors;

public class Request404 extends RuntimeException{
    public Request404(String message) {
        super(message);
    }
}
