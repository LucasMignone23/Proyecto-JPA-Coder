package com.proyecto.coder.jpa.projecto.jpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
