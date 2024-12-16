package com.example.trabajounidad3.modelo;

import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;

import java.util.Date;

public class PartesDeArriba extends Ropa implements Parcelable {
    private String corte;

    public PartesDeArriba(int idImagen, String color, String talla, String nombre, String tipo, Date fecha, String corte) {
        super(idImagen, color, talla, nombre, tipo, fecha);
        this.corte = corte;
    }

    protected PartesDeArriba(Parcel in) {
        super(in);
        corte = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(corte);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PartesDeArriba> CREATOR = new Creator<PartesDeArriba>() {
        @Override
        public PartesDeArriba createFromParcel(Parcel in) {
            return new PartesDeArriba(in);
        }

        @Override
        public PartesDeArriba[] newArray(int size) {
            return new PartesDeArriba[size];
        }
    };

    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }

}
