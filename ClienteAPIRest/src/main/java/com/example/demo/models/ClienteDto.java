package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
    private String nombre;
    private String apellido;
    private int edad;

    public ClienteDto(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
