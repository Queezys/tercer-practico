package com.unlar.programacion.tercer_practico.controller;

import com.unlar.programacion.tercer_practico.model.Album;
import com.unlar.programacion.tercer_practico.service.AlbumService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/albumes")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public ResponseEntity<List<Album>> listarTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        List<Album> albumes = albumService.obtenerAlbumes().stream()
                .skip((long) page * size)
                .limit(size)
                .toList();

        return ResponseEntity.ok(albumes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> buscarPorId(@PathVariable String id) {
        return albumService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Album>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(albumService.buscarPorTitulo(nombre));
    }
}
