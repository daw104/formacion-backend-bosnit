package com.example.block11cors.demo.Person.Errors;

public class Request404 extends RuntimeException{
    public Request404(String message) {
        super(message);
    }
}
