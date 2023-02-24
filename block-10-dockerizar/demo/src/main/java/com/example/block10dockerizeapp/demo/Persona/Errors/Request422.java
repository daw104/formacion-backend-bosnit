package com.example.block10dockerizeapp.demo.Persona.Errors;

public class Request422 extends RuntimeException{
    public Request422(String message) {
        super(message);
    }
}
