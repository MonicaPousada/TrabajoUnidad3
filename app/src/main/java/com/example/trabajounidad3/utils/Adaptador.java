package com.example.trabajounidad3.utils;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajounidad3.R;
import com.example.trabajounidad3.modelo.PartesDeAbajo;
import com.example.trabajounidad3.modelo.PartesDeArriba;
import com.example.trabajounidad3.modelo.Ropa;
import com.example.trabajounidad3.modelo.Zapatos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Adaptador extends RecyclerView.Adapter<Adaptador.RopaViewHolder>{
//Lista que almacena las prendas que se mostrarán en el RecyclerView
    ArrayList<Ropa> listaPrendas;

//Constructor que recibe la lista de prendas como parámetro
    public Adaptador(ArrayList<Ropa> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }

//Método que se llama al crear una nueva vista (ViewHolder) para un elemento del RecyclerView
    @NonNull
    @Override
    public Adaptador.RopaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//Inflar la vista desde el layout 'vista.xml' y crear un nuevo ViewHolder con ella
        Adaptador.RopaViewHolder ropaViewHolder =
                new RopaViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.vista,parent,false)
                );
        return ropaViewHolder;
    }

//Método que se llama para enlazar los datos de un elemento con su ViewHolder
    @Override
    public void onBindViewHolder(@NonNull Adaptador.RopaViewHolder holder, int position) {
//Obtener la prenda correspondiente a la posición actual
        Ropa prenda = listaPrendas.get(position);
//Establecer la imagen correspondiente en el ImageView
        holder.imagen.setImageResource(prenda.getIdImagen());

//Verificar el tipo de la prenda y establecer la información de ella dependiendo de la clase en el TextView dándole estilo
        if (prenda instanceof PartesDeArriba){
            String nom = prenda.getNombre();
            SpannableString nombre = new SpannableString(nom);
            nombre.setSpan(new StyleSpan(Typeface.BOLD), 0, nombre.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            String info = "\n Talla: "+prenda.getTalla()+"\n Color: "+prenda.getColor()+"\n Corte: "+((PartesDeArriba) prenda).getCorte();
            SpannableStringBuilder mensaje = new SpannableStringBuilder(nombre);
            mensaje.append(info);
            holder.info.setText(mensaje);
        } else if (prenda instanceof PartesDeAbajo) {
            String nom = prenda.getNombre();
            SpannableString nombre = new SpannableString(nom);
            nombre.setSpan(new StyleSpan(Typeface.BOLD), 0, nombre.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            String info =  "\n Talla: "+prenda.getTalla()+"\n Color: "+prenda.getColor()+"\n Corte: "+((PartesDeAbajo) prenda).getCorte()+"\n Tiro: "+ ((PartesDeAbajo) prenda).getTiro();
            SpannableStringBuilder mensaje = new SpannableStringBuilder(nombre);
            mensaje.append(info);
            holder.info.setText(mensaje);
        } else if (prenda instanceof Zapatos) {
            String nom = prenda.getNombre();
            SpannableString nombre = new SpannableString(nom);
            nombre.setSpan(new StyleSpan(Typeface.BOLD), 0, nombre.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            String info =  "\n Talla: "+prenda.getTalla()+"\n Color: "+prenda.getColor();
            SpannableStringBuilder mensaje = new SpannableStringBuilder(nombre);
            mensaje.append(info);
            holder.info.setText(mensaje);
        }

//Configurar el texto del botón
        holder.boton.setText(R.string.btnUso);
//Definir la acción al hacer clic en el botón
        holder.boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Crear un objeto Date con la fecha actual
                Date fechaActual = new Date();

                prenda.setFecha(fechaActual);
//Lanzar toast informando
                Toast.makeText(view.getContext(), "Registro de uso guardado correctamente.", Toast.LENGTH_SHORT).show();
            }
        });

//Definir la acción al hacer click en el elemento de la lista
        holder.itemView.setOnClickListener(view -> {
            if (prenda.getFecha() != null) {
//Mostrar la fecha de último uso si está registrada
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String fechaFormateada = formato.format(prenda.getFecha());
                String texto = prenda.getNombre() + " usado por última vez el " + fechaFormateada;
                Toast.makeText(view.getContext(), texto, Toast.LENGTH_LONG).show();
            } else {
//Si no hay fecha, es decir, si no se ha usado, mostrar un mensaje indicando que nunca se ha usado
                Toast.makeText(view.getContext(), "La prenda nunca ha sido usada.", Toast.LENGTH_SHORT).show();
            }
        });

    }

//Método que devuelve la cantidad de elementos en la lista
    @Override
    public int getItemCount() {
        return listaPrendas.size();
    }

//Clase interna que define el ViewHolder para la lista de prendas
    public class RopaViewHolder extends RecyclerView.ViewHolder{
//Componentes del layout 'vista.xml'
        ImageView imagen;
        TextView info;
        Button boton;

//Constructor que inicializa los componentes de la vista
        public RopaViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen);
            info = itemView.findViewById(R.id.info);
            boton = itemView.findViewById(R.id.boton);

        }
    }
}
