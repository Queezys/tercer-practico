package com.unlar.programacion.tercer_practico.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Album {

    private String id;
    private String titulo;
    private int anioLanzamiento;
    private Artista artista;
    private Productora productora;
    @JsonIgnore
    private List<Cancion> canciones;

    public Album(String id, String titulo, int anioLanzamiento, Artista artista, Productora productora) {
        this.id = id;
        this.titulo = titulo;
        this.anioLanzamiento = anioLanzamiento;
        this.artista = artista;
        this.productora = productora;
    }
}
