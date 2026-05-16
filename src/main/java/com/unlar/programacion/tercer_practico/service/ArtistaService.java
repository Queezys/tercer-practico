package com.unlar.programacion.tercer_practico.service;

import com.unlar.programacion.tercer_practico.data.DataLoader;
import com.unlar.programacion.tercer_practico.model.Artista;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {

    private final List<Artista> artistas;

    public ArtistaService(DataLoader dataLoader) {
        this.artistas = new ArrayList<>(dataLoader.obtenerArtistas());
    }

    public List<Artista> obtenerArtistas() {
        return artistas;
    }

    public Optional<Artista> buscarPorId(String id) {
        return artistas.stream()
                .filter(artista -> artista.getId().equals(id))
                .findFirst();
    }

    public List<Artista> buscarPorNombre(String nombre) {
        return artistas.stream()
                .filter(artista -> artista.getNombre().equalsIgnoreCase(nombre))
                .toList();
    }
}
