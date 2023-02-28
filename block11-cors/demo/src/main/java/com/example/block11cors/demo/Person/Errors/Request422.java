package com.example.block11cors.demo.Person.Errors;

public class Request422 extends RuntimeException{
    public Request422(String message) {
        super(message);
    }
}
