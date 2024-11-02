package com.proyecto.coder.jpa.projecto.jpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String telefonoDeContacto;

    @Column(nullable = false, unique = true)
    private String numeroDeCuit;

    public Cliente(String nombre, String mail, String direccion, String telefonoDeContacto, String numeroDeCuit) {
        this.nombre = nombre;
        this.mail = mail;
        this.direccion = direccion;
        this.telefonoDeContacto = telefonoDeContacto;
        this.numeroDeCuit = numeroDeCuit;
    }
}
