package com.firtsappspring.tutospring.models;

public class Producto {
    // DTO
    /* Se aconseja no usar getters y setters para una estructura de datos, 
    sino usar propiedades declarando las propiedades en public, a menos que sea necesario modificarlas */
    public String nombre;
    public int precio;

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

}
