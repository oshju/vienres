package com.example.ejemplos;

public class Cliente {
    private String nombre;
    private String haabilidad;
    private String tipo;


    public Cliente(String nombre, String haabilidad, String tipo) {
        this.nombre = nombre;
        this.haabilidad = haabilidad;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHaabilidad() {
        return haabilidad;
    }

    public void setHaabilidad(String haabilidad) {
        this.haabilidad = haabilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
