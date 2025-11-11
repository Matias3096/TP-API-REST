package com.utn.Tp_Api_Rest.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column( length = 500)
    private String descripcion;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private Integer stock;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;
}
