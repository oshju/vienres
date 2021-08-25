package com.example.ejemplos;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.proyectoapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private List<Cliente> listaClientes;
    private TextView txthabilidad;

    public Adaptador(List<Cliente> ListaCliente) {
        this.listaClientes = ListaCliente;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_datos, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }





    @Override
    public int getItemCount()
    {
        return listaClientes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtnombre;
        public ViewHolder(View v) {
            super(v);
            txtnombre = (TextView) v.findViewById(R.id.txtnombre1);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String nombre = listaClientes.get(position).getNombre();
        holder.txtnombre.setText(nombre);
        loadPokemon();
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

                            notifyDataSetChanged();
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
