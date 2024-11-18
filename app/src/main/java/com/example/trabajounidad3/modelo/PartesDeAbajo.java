package com.example.trabajounidad3.modelo;

public class PartesDeAbajo extends Ropa {
    private String corte;
    private String tiro;

    public PartesDeAbajo(String nombre, String color, String talla, String corte, String tiro) {
        super(nombre, color, talla);
        this.corte = corte;
        this.tiro = tiro;
    }

    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }

    public String getTiro() {
        return tiro;
    }

    public void setTiro(String tiro) {
        this.tiro = tiro;
    }
}
