package com.gabyrest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Id;
private String nombre;
private double precio;
public Long getId() {
    return Id;
}
public void setId(Long id) {
    Id = id;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public double getPrecio() {
    return precio;
}
public void setPrecio(double precio) {
    this.precio = precio;
}

}
