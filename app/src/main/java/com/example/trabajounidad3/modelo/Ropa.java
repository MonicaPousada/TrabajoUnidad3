package com.example.trabajounidad3.modelo;

public class Ropa {
    private String nombre;
    private String talla;
    private String color;

    public Ropa(String nombre, String color, String talla) {
        this.nombre = nombre;
        this.color = color;
        this.talla = talla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
