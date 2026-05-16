package com.unlar.programacion.tercer_practico.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Productora {
    private String id;
    private String nombre;
    @JsonIgnore
    private List<Album> albumes;
    @JsonIgnore
    private List<Artista> artistas;

    public Productora(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
}
