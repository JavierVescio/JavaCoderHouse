package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column()
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn
    private Cliente cliente;

    @Column(nullable = false)
    private float precioTotal = 0;

    @Column(columnDefinition = "boolean")
    private boolean confirmada = false;

}