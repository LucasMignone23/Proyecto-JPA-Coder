package com.proyecto.coder.jpa.projecto.jpa.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private Long clienteId;

    private String nombre;

    private String mail;

    private String direccion;

    private String telefonoDeContacto;

    private String numeroDeCuit;
}
