package com.proyecto.coder.jpa.projecto.jpa.dto;

import java.util.Date;

public class ComprobanteResponseDTO {
    private double totalVenta;
    private int cantidadProductos;
    private Date fecha; // Cambiado a Date
    private String mensajeError;

    // Getters y Setters
    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) { // Cambiado a Date
        this.fecha = fecha;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
