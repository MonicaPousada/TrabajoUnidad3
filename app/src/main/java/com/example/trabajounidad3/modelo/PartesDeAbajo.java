package com.example.trabajounidad3.modelo;

import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;

import java.util.Date;

public class PartesDeAbajo extends Ropa implements Parcelable {
    private String corte;
    private String tiro;

    public PartesDeAbajo(int idImagen, String color, String talla, String nombre, String tipo, Date fecha, String corte, String tiro) {
        super(idImagen, color, talla, nombre, tipo, fecha);
        this.corte = corte;
        this.tiro = tiro;
    }

    protected PartesDeAbajo(Parcel in) {
        super(in);
        corte = in.readString();
        tiro = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(corte);
        dest.writeString(tiro);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PartesDeAbajo> CREATOR = new Creator<PartesDeAbajo>() {
        @Override
        public PartesDeAbajo createFromParcel(Parcel in) {
            return new PartesDeAbajo(in);
        }

        @Override
        public PartesDeAbajo[] newArray(int size) {
            return new PartesDeAbajo[size];
        }
    };

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
