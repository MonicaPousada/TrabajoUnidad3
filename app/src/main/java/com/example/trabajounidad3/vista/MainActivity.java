package com.example.trabajounidad3.vista;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajounidad3.R;
import com.example.trabajounidad3.modelo.PartesDeAbajo;
import com.example.trabajounidad3.modelo.PartesDeArriba;
import com.example.trabajounidad3.modelo.Ropa;
import com.example.trabajounidad3.modelo.Zapatos;
import com.example.trabajounidad3.utils.Adaptador;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Switch arriba;
    private Switch abajo;
    private Switch zapatos;
    private String TAG = "EJEMPLO";
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//Creo un array con prendas para usar la aplicación
        ArrayList <Ropa> prendas = new ArrayList<>();

//Añado las prendas en un bloque try catch por si hubiera algún problema a la hora de crearlas o añadirlas
        try {
            prendas.add(new PartesDeArriba(R.drawable.partedearriba1, "Negro", "L", "TOP NEGRO", "arriba", null, "Crop"));
            prendas.add(new PartesDeArriba(R.drawable.partedearriba2, "Blanco", "L", "TOP BLANCO", "arriba", null, "Regular"));
            prendas.add(new PartesDeArriba(R.drawable.partedearriba3, "Negro", "L", "TOP NEGRO ASIMÉTRICO", "arriba", null, "Asimétrico"));
            prendas.add(new PartesDeArriba(R.drawable.partedearriba4, "Blanco", "XL", "CAMISA BLANCA", "arriba", null, "Oversize"));
            prendas.add(new PartesDeAbajo(R.drawable.partedeabajo1, "Blanco", "42", "PANTALÓN BLANCO", "abajo", null, "Straight", "Alto"));
            prendas.add(new PartesDeAbajo(R.drawable.partedeabajo2, "Negro", "42", "PANTALÓN NEGRO", "abajo", null, "Straight", "Alto"));
            prendas.add(new PartesDeAbajo(R.drawable.partedeabajo3, "Rosa", "42", "PANTALÓN ROSA", "abajo", null, "Cargo", "Medio"));
            prendas.add(new PartesDeAbajo(R.drawable.partedeabajo4, "Negro", "40", "PANTALÓN POLIPIEL NEGRO", "abajo", null, "Straight", "Alto"));
            prendas.add(new Zapatos(R.drawable.zapatos1, "Negro", "38,5", "NEW BALANCE 327", "zapatos", null));
            prendas.add(new Zapatos(R.drawable.zapatos2, "Rojo", "39", "NIKE AIR JORDAN", "zapatos", null));
            prendas.add(new Zapatos(R.drawable.zapatos3, "Gris", "38,5", "ADIDAS CAMPUS 2000", "zapatos", null));
            prendas.add(new Zapatos(R.drawable.zapatos4, "Lila y rosa", "38", "NIKE DUNK INDIGO HAZE", "zapatos", null));
        } catch (Exception e) {
            Log.e(TAG, "Error al rellenar el array: " + e.getMessage());
        }
        Log.i(TAG, "Creando el array de prendas");

//Creo el array de prendas de los Switch, el adaptador, me traigo el RecyclerView y le pongo el adaptador
        ArrayList <Ropa> prendasSwitch = new ArrayList<>();

        adaptador = new Adaptador(prendas);

        RecyclerView rvPrendas = findViewById(R.id.vista);
        rvPrendas.setLayoutManager(new LinearLayoutManager(this));

        rvPrendas.setAdapter(adaptador);
        Log.i(TAG, "Creando el adaptador y añadiéndoselo a la vista");

//Me traigo con el id los 3 Switch de la vista
        arriba = findViewById(R.id.arriba);
        abajo = findViewById(R.id.abajo);
        zapatos = findViewById(R.id.zapatos);
        Log.i(TAG, "Trayendo los Switch de la vista");

//Creo un On Checked Change Listener para el Switch
        arriba.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.i(TAG, "En el metodo on Checked Changed del Switch partes de arriba");
//Le especifico que si está activo se añadan las prendas filtradas al array de los Switch , creo un nuevo adaptador y se lo paso al RecyclerView
                if(arriba.isChecked()){
                    Log.i(TAG, "En el if activo del Switch de partes de arriba");
                    for (int i = 0; i<prendas.size(); i++){
                        if (prendas.get(i) instanceof PartesDeArriba){
                            if (!prendasSwitch.contains(prendas.get(i))) {
                                Log.i(TAG, "Eliminando prendas del array");
                                prendasSwitch.add(prendas.get(i));
                            }
                        }
                    }

                    adaptador = new Adaptador(prendasSwitch);
                    rvPrendas.setAdapter(adaptador);
                    Log.i(TAG, "Creando el adaptador y pasándoselo a la RecyclerView");

                }
//Si se desactiva compruebo otras cosas
                else{
//Si hay otros Switch activos borro las prendas de este del array y muestro las que siguen filtradas por otros Switch
                    Log.i(TAG, "En el else desactivado del Switch de partes de arriba");
                    if (abajo.isChecked() || zapatos.isChecked()){
                        Log.i(TAG, "En el if de otros Switch activos de partes de arriba");
                        for (int i = prendasSwitch.size() - 1; i >= 0; i--){
                            if (prendasSwitch.get(i) instanceof PartesDeArriba){
                                prendasSwitch.remove(i);
                                Log.i(TAG, "Eliminando prendas del array");
                            }
                        }

                        adaptador = new Adaptador(prendasSwitch);
                        rvPrendas.setAdapter(adaptador);
                        Log.i(TAG, "Creando el adaptador y pasándoselo a la RecyclerView");
                    }
//Si no hay otros Switch activos borro el array de filtros para el próximo uso y le paso el array de todas las prendas
                    else{
                        Log.i(TAG, "En el else de otros Switch desactivados de partes de arriba");
                        prendasSwitch.clear();
                        adaptador = new Adaptador(prendas);
                        rvPrendas.setAdapter(adaptador);
                        Log.i(TAG, "Borrando el array, creando el adaptador y pasándoselo a la RecyclerView");
                    }
                }
            }
        });

//Repito el proceso del Switch anterior
        abajo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.i(TAG, "En el metodo on Checked Changed del Switch partes de abajo");
                if(abajo.isChecked()){
                    Log.i(TAG, "En el if activo del Switch de partes de abajo");
                    for (int i = 0; i<prendas.size(); i++){
                        if (prendas.get(i) instanceof PartesDeAbajo){
                            if (!prendasSwitch.contains(prendas.get(i))) {
                                prendasSwitch.add(prendas.get(i));
                                Log.i(TAG, "Eliminando prendas del array");
                            }
                        }
                    }

                    adaptador = new Adaptador(prendas);
                    rvPrendas.setAdapter(adaptador);
                    Log.i(TAG, "Creando el adaptador y pasándoselo a la RecyclerView");
                }
                else{
                    Log.i(TAG, "En el else desactivado del Switch de partes de abajo");
                    if (arriba.isChecked() || zapatos.isChecked()){
                        Log.i(TAG, "En el if de otros Switch activos de partes de abajo");
                        for (int i = prendasSwitch.size() - 1; i >= 0; i--){
                            if (prendasSwitch.get(i) instanceof PartesDeAbajo){
                                prendasSwitch.remove(i);
                                Log.i(TAG, "Eliminando prendas del array");
                            }
                        }
                        adaptador = new Adaptador(prendas);
                        rvPrendas.setAdapter(adaptador);
                        Log.i(TAG, "Creando el adaptador y pasándoselo a la RecyclerView");
                    }
                    else{
                        Log.i(TAG, "En el else de otros Switch desactivados de partes de abajo");
                        prendasSwitch.clear();
                        adaptador = new Adaptador(prendas);
                        rvPrendas.setAdapter(adaptador);
                        Log.i(TAG, "Borrando el array, creando el adaptador y pasándoselo a la RecyclerView");
                    }
                }
            }
        });

//Repito el proceso del Switch anterior
        zapatos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.i(TAG, "En el metodo on Checked Changed del Switch zapatos");
                if(zapatos.isChecked()){
                    for (int i = 0; i<prendas.size(); i++){
                        Log.i(TAG, "En el if activo del Switch de zapatos");
                        if (prendas.get(i) instanceof Zapatos){
                            if (!prendasSwitch.contains(prendas.get(i))) {
                                prendasSwitch.add(prendas.get(i));
                                Log.i(TAG, "Eliminando prendas del array");
                            }
                        }
                    }

                    adaptador = new Adaptador(prendas);
                    rvPrendas.setAdapter(adaptador);
                    Log.i(TAG, "Creando el adaptador y pasándoselo a la RecyclerView");
                }
                else{
                    Log.i(TAG, "En el else desactivado del Switch de zapatos");
                    if (abajo.isChecked() || arriba.isChecked()){
                        Log.i(TAG, "En el if de otros Switch activos de zapatos");
                        for (int i = prendasSwitch.size() - 1; i >= 0; i--){
                            if (prendasSwitch.get(i) instanceof Zapatos){
                                prendasSwitch.remove(i);
                                Log.i(TAG, "Eliminando prendas del array");
                            }
                        }
                        adaptador = new Adaptador(prendas);
                        rvPrendas.setAdapter(adaptador);
                        Log.i(TAG, "Creando el adaptador y pasándoselo a la RecyclerView");
                    }
                    else{
                        Log.i(TAG, "En el else de otros Switch desactivados de zapatos");
                        prendasSwitch.clear();
                        adaptador = new Adaptador(prendas);
                        rvPrendas.setAdapter(adaptador);
                        Log.i(TAG, "Borrando el array, creando el adaptador y pasándoselo a la RecyclerView");
                    }
                }
            }
        });

//Me traigo la toolbar, creo un SpannableString con el titulo y se lo añado
        Toolbar toolbar = findViewById(R.id.toolbar);
        SpannableString titulo = new SpannableString(getString(R.string.titulo));
        titulo.setSpan(new StyleSpan(Typeface.BOLD), 0, titulo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titulo.setSpan(new ForegroundColorSpan(Color.WHITE), 0, titulo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        toolbar.setTitle(titulo);
        setSupportActionBar(toolbar);
        Log.i(TAG, "Trayendo la Toolbar y añadiéndole el título");

//Le añado el Listener para el botón de cerrar actividad
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "En el metodo onClick del listener del botón cerrar de la Toolbar");
                finishAffinity();
            }
        });



    }


//Creo el menú y le añado las opciones del XML creado
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menú; agrega los elementos a la Toolbar
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        Log.i(TAG, "En el metodo onCreateOptionsMenu inflando el menú");
        return true;
    }

//Gestiono la selección de la opción del menú.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Se ha seleccionado la opción '"+item.getTitle()+"'.", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "En el metodo onOptionsItemSelected lanzando el toast");
        return true;
    }
}



























