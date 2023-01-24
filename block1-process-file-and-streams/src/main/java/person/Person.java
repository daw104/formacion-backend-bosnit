package person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    //atributos
    private String name;
    private String town;
    private int age;

//    constructor
    public Person(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public Person(){

    }

    //getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //toString
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", age=" + age +
                '}';
    }









}
