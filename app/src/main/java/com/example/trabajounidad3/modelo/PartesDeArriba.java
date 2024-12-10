package com.example.trabajounidad3.modelo;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;

import java.io.Serializable;
import java.util.Date;

public class PartesDeArriba extends Ropa implements Serializable {
    private String corte;

    public PartesDeArriba(int idImagen, String color, String talla, String nombre, String tipo, Date fecha, String corte) {
        super(idImagen, color, talla, nombre, tipo, fecha);
        this.corte = corte;
    }

    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }

}
