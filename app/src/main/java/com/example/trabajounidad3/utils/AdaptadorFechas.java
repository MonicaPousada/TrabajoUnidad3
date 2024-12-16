package com.example.trabajounidad3.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdaptadorFechas {

    public static String exportDate (Date fecha){
        return fecha.toString();
    }

    public static Date importDate (String fecha){
        String fechaComoString = "2024-12-16";
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date objetoFecha = formato.parse(fechaComoString);
            return objetoFecha;
        } catch (ParseException e) {
            System.out.println("Error al convertir el String a Date: " + e.getMessage());
        }
        return null;
    }
}
