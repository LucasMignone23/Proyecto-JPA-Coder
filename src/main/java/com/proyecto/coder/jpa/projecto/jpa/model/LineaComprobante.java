package com.proyecto.coder.jpa.projecto.jpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LineaComprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Producto producto;

    private int cantidad;
}
