package com.proyecto.coder.jpa.projecto.jpa.dto;

import java.util.List;

public class ComprobanteRequestDTO {
    private ClienteDTO cliente;
    private List<LineaComprobanteDTO> lineas;

    // Getters y Setters
    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<LineaComprobanteDTO> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaComprobanteDTO> lineas) {
        this.lineas = lineas;
    }
}
