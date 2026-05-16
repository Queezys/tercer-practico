package com.unlar.programacion.tercer_practico.model;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Cancion implements Comparable <Cancion>{

    private String id;
    private String titulo;
    private Artista artista;
    private Album album;
    private Productora productora;
    private Genero genero;
    private int duracionSegundos;
    private AtomicInteger Reproducciones;
    private double rating;
    private LocalDate fechaLanzamiento;
    
    public Cancion(String id, String titulo, Artista artista, Album album, Productora productora, Genero genero,
            int duracionSegundos, AtomicInteger reproducciones, double rating, LocalDate fechaLanzamiento) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.productora = productora;
        this.genero = genero;
        this.duracionSegundos = duracionSegundos;
        Reproducciones = reproducciones;
        this.rating = rating;
        this.fechaLanzamiento = fechaLanzamiento;

    }

    @Override
        public int compareTo(Cancion otra) {
            return this.titulo.compareToIgnoreCase(otra.getTitulo());
        }
}
