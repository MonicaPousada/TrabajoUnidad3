package com.example.trabajounidad3.modelo;

public class PartesDeArriba extends Ropa {
    private String corte;

    public PartesDeArriba(String nombre, String color, String talla, String corte) {
        super(nombre, color, talla);
        this.corte = corte;
    }

    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }
}
