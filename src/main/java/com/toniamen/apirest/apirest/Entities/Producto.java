package com.toniamen.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //decorador para que la clase sea de tipo entity.
public class Producto {

    @Id //decorador para identificar clave primaria en la base de datos.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //decorador para genarar un  id autoincremental.
    private Long id;
    private String nombre;
    private Double precio;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    


}
