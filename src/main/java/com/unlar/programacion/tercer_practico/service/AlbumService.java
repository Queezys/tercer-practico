package com.unlar.programacion.tercer_practico.service;

import com.unlar.programacion.tercer_practico.data.DataLoader;
import com.unlar.programacion.tercer_practico.model.Album;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    private final List<Album> albumes;

    public AlbumService(DataLoader dataLoader) {
        this.albumes = new ArrayList<>(dataLoader.obtenerAlbumes());
    }

    public List<Album> obtenerAlbumes() {
        return albumes;
    }

    public Optional<Album> buscarPorId(String id) {
        return albumes.stream()
                .filter(album -> album.getId().equals(id))
                .findFirst();
    }

    public List<Album> buscarPorTitulo(String titulo) {
        return albumes.stream()
                .filter(album -> album.getTitulo().equalsIgnoreCase(titulo))
                .toList();
    }
}