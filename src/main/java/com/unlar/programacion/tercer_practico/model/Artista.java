package com.unlar.programacion.tercer_practico.model;

import com.unlar.programacion.tercer_practico.service.CancionService;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Artista implements Comparable<Artista>{
    private String id;
    private String nombre;
    private String nacionalidad;
    

    public Artista(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    @Override
    public int compareTo(Artista otro){
        return this.nombre.compareToIgnoreCase(otro.getNombre());
    }
}
