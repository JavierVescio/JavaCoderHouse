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
    @JoinColumn(name = "cliente_id" )
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "venta")
    private List<ItemVenta> items = new ArrayList<>();

    @Column(nullable = false)
    private float precioTotal = 0;

    @Column(columnDefinition = "boolean default false")
    private boolean confirmada = false;

    public void addItemVenta(ItemVenta itemVenta){
        items.add(itemVenta);
        itemVenta.setVenta(this);
    }
}