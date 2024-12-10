package com.example.trabajounidad3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trabajounidad3.modelo.Ropa;
import com.example.trabajounidad3.utils.Adaptador;
import com.example.trabajounidad3.vista.MainActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRecyclerView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRecyclerView extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Adaptador adaptador;
    private ArrayList <Ropa> prendas;

    public FragmentRecyclerView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRecyclerView.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRecyclerView newInstance(String param1, String param2) {
        FragmentRecyclerView fragment = new FragmentRecyclerView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            prendas = (ArrayList<Ropa>) getArguments().getSerializable("arrayPrendas");
            if (prendas !=null){
                Log.i("EJEMPLO", "prendas != null");
            }
            mParam2 = getArguments().getString(ARG_PARAM2);
            adaptador = new Adaptador(prendas);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        RecyclerView rvPrendas = vista.findViewById(R.id.recyclerView);
        rvPrendas.setLayoutManager(new LinearLayoutManager(vista.getContext()));

        rvPrendas.setAdapter(adaptador);

        return vista;
    }
}