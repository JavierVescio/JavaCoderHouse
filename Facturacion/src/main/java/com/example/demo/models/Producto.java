package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private float precio;

    @Column(nullable = false)
    private int stock;


}
