package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ItemVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id" )
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id" )
    private Producto producto;

    @Column()
    private int cantidad;

    @Column()
    private float subtotal;

}