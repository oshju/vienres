package com.example.proyectoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ejemplos.Adaptador;
import com.example.ejemplos.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Ventana6 extends AppCompatActivity {
    private RecyclerView miRecicler;
    private RecyclerView.Adapter miAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana6);
        miRecicler = (RecyclerView) findViewById(R.id.rc1);

// Añadimos que  el tamaño del RecyclerView no se cambiará.

// que tiene hijos (items) que tienen anchura y altura fijas. Permite // que el RecyclerView optimice mejor

        //miRecicler = (RecyclerView) findViewById(R.id.RV1);

// Añadimos que  el tamaño del RecyclerView no se cambiará.

// que tiene hijos (items) que tienen anchura y altura fijas. Permite // que el RecyclerView optimice mejor

        miRecicler.setHasFixedSize(true);

        miRecicler.setLayoutManager(new LinearLayoutManager(this));
        //Especificamos el adaptador con la lista a visualizar
        miAdapter = new Adaptador(DatosClientes());
        miRecicler.setAdapter(miAdapter);

    }
        public List<Cliente> DatosClientes() {

            List<Cliente> Lista = new ArrayList<>();
            Lista.add(new Cliente("Rey","rayo","electrico"));
            Lista.add(new Cliente("pikachu","rayo","electrico"));
            Lista.add(new Cliente("evee","rayo","electrico"));
            return Lista;
        }


    }
