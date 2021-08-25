package com.example.proyectoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.ejemplos.Adaptador;
import com.example.ejemplos.Cliente;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
            Lista.add(new Cliente("pikachu"));
            Lista.add(new Cliente("charmander"));


            return Lista;
        }

    private List<Cliente> pokemon = new ArrayList<>();
    private RequestQueue requestQueue;

    public void loadPokemon() {
        String url = "https://pokeapi.co/api/v2/pokemon?limit=151";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, (String) null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray results = response.getJSONArray("results");
                            for (int i = 0; i < results.length(); i++) {
                                JSONObject result = results.getJSONObject(i);
                                pokemon.add(new Cliente(
                                        result.getString("nombre")));


                            }

                            //notifyDataSetChanged();
                        } catch (JSONException e) {
                            Log.e("cs50", "onResponse: ", e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("cs50", "onErrorResponse: pokemon list error");
            }
        });
        requestQueue.add(request);

        loadPokemon();
    }


    }
