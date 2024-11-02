package com.proyecto.coder.jpa.projecto.jpa.dto;

public class LineaComprobanteDTO {
    private ProductoDTO producto;
    private int cantidad;

    // Getters y Setters
    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
