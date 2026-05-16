package com.unlar.programacion.tercer_practico.controller;

import com.unlar.programacion.tercer_practico.model.Artista;
import com.unlar.programacion.tercer_practico.service.ArtistaService;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    private final ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @GetMapping
    public ResponseEntity<List<Artista>> listarTodos(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int size) {

        List<Artista> artistas = artistaService.obtenerArtistas().stream()
                .skip((long) pagina * size)
                .limit(size)
                .collect(Collectors.toList());

        return ResponseEntity.ok(artistas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> buscarPorId(@PathVariable String id) {
        return artistaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Artista>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(artistaService.buscarPorNombre(nombre));
    }
}
