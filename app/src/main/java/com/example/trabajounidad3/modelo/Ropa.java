package com.example.trabajounidad3.modelo;

import static com.example.trabajounidad3.utils.AdaptadorFechas.exportDate;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class Ropa implements Parcelable {
    private int idImagen;
    private Date fecha;
    private String tipo;
    private String nombre;
    private String talla;
    private String color;

    public Ropa(int idImagen, String color, String talla, String nombre, String tipo, Date fecha) {
        this.idImagen = idImagen;
        this.color = color;
        this.talla = talla;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
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

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(idImagen);
        parcel.writeString(exportDate(fecha));
        parcel.writeString(tipo);
        parcel.writeString(nombre);
        parcel.writeString(talla);
        parcel.writeString(color);

    }
}
