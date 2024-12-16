package com.example.trabajounidad3.modelo;

import java.util.Date;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;

public class Zapatos extends Ropa implements Parcelable {

    public Zapatos(int idImagen, String color, String talla, String nombre, String tipo, Date fecha) {
        super(idImagen, color, talla, nombre, tipo, fecha);
    }

}
