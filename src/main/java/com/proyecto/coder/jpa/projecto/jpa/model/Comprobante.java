package com.proyecto.coder.jpa.projecto.jpa.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LineaComprobante> lineas;

    private Date fecha;
    private double totalVenta;
    private int cantidadTotalProductos;
}
