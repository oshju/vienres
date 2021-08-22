package com.example.ejemplos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapp.R;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private List<Cliente> listaClientes;

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
    public void onBindViewHolder(ViewHolder holder, int position) {
        String nombre = listaClientes.get(position).getNombre();
        holder.txtnombre.setText(nombre);
    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtnombre;
        public ViewHolder(View v) {
            super(v);
            txtnombre = (TextView) v.findViewById(R.id.txtnombre);
        }
    }

}
