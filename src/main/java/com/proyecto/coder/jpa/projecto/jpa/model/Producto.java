package com.proyecto.coder.jpa.projecto.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental
    private Long id;

    @Column(nullable = false) // Columna obligatoria
    private String nombre;

    private double precio; // Precio del producto
    private int cantidad; // Cantidad en stock

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria; // Relación ManyToOne con Categoria

    // Constructor adicional para agregar producto
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
