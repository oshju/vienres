package com.example.ejemplos;

public class Cliente {
    private String nombre;
    private String haabilidad;



    public Cliente(String nombre, String haabilidad) {
        this.nombre = nombre;
        this.haabilidad = haabilidad;
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




}
