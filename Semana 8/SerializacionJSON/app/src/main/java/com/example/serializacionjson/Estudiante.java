package com.example.serializacionjson;

public class Estudiante {


    private String nombre;
    private String email;
    private String university;
    private String username;

    public Estudiante() {
    }

    public Estudiante(String nombre, String email, String university, String username) {
        this.nombre = nombre;
        this.email=email;
        this.university=university;
        this.username=username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




}
