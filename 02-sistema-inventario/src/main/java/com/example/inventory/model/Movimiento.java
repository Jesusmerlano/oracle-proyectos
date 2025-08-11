package com.example.inventory.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name="movimientos", schema="INV_USER")
public class Movimiento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name="producto_id") private Long productoId;
    private String tipo;
    private Integer cantidad;
    private OffsetDateTime fecha;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public OffsetDateTime getFecha() { return fecha; }
    public void setFecha(OffsetDateTime fecha) { this.fecha = fecha; }
}
