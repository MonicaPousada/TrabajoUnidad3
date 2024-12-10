package com.example.trabajounidad3.modelo;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;

import java.io.Serializable;
import java.util.Date;

public class PartesDeAbajo extends Ropa implements Serializable {
    private String corte;
    private String tiro;

    public PartesDeAbajo(int idImagen, String color, String talla, String nombre, String tipo, Date fecha, String corte, String tiro) {
        super(idImagen, color, talla, nombre, tipo, fecha);
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
