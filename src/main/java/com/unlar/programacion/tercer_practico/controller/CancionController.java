package com.unlar.programacion.tercer_practico.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.unlar.programacion.tercer_practico.service.CancionService;
import com.unlar.programacion.tercer_practico.model.Artista;
import com.unlar.programacion.tercer_practico.model.Cancion;
import com.unlar.programacion.tercer_practico.model.Genero;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/canciones") 
public class CancionController {

    private final CancionService cancionService;
    
    public CancionController(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    @GetMapping
    public ResponseEntity<List<Cancion>> listarTodas(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int size) {

        List<Cancion> paginadas = cancionService.obtenerCanciones().stream()
                .skip((long) pagina * size)
                .limit(size)
                .toList();

        return ResponseEntity.ok(paginadas);
    }

    @GetMapping("/top10")
    ResponseEntity<List<Cancion>> top10(){

        return ResponseEntity.ok(cancionService.obtenerTop10()); 
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Cancion>> buscar(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String artista) {

        List<Cancion> resultado = cancionService.buscarPorTituloYArtista(titulo, artista);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/busqueda-binaria")
    public ResponseEntity<Cancion> busquedaBinariaCancion(@RequestParam String titulo) {
        Cancion cancion = cancionService.busquedaTituloCancionBinaria(titulo);
        if (cancion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cancion);
    }

    @GetMapping("/busqueda-lineal")
    public ResponseEntity<List<Cancion>> busquedaLineal(
        @RequestParam Genero genero,
        @RequestParam int anio,
        @RequestParam double rating){

        return ResponseEntity.ok(cancionService.busquedaLineal(genero, anio, rating));
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<Cancion>> busquedaFiltroCompuesto(
        @RequestParam Genero genero, 
        @RequestParam String artista, 
        @RequestParam int anioInicio, 
        @RequestParam int anioFin,
        @RequestParam double ratingMin){

            return ResponseEntity.ok(cancionService.buscarConFiltroCompuesto(genero, artista, anioInicio, anioFin, ratingMin));
        }

    @GetMapping("/{id}")
    public ResponseEntity<Cancion> buscarPorId(@PathVariable String id) {
        return cancionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/recomendaciones/genero")
    public ResponseEntity<List<Cancion>> recomendarPorGenero(@PathVariable String id) {
        return cancionService.recomendarPorGenero(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/recomendaciones/popularidad")
    public ResponseEntity<List<Cancion>> recomendarPorPopularidad() {
        return ResponseEntity.ok(cancionService.recomendarPorPopularidad());
    }

    @GetMapping("/{id}/recomendaciones/descubrimiento")
    public ResponseEntity<List<Cancion>> recomendarPorDescubrimiento(@PathVariable String id) {
        return cancionService.recomendarPorDescubrimiento(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/{id}/reproducir")
    public ResponseEntity<Cancion> reproducir(@PathVariable String id) {
        return cancionService.reproducir(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estadisticas/artista-mas-popular")
    public ResponseEntity<Artista> artistaMasPopular() {
        Artista artista = cancionService.artistaMasPopular();

        if (artista == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(artista);
    }

    @GetMapping("/estadisticas/promedio-segundos-por-genero")
    public ResponseEntity<Map<Genero,Double>> promedioPorGenero (){
        return ResponseEntity.ok(cancionService.promedioDuracionPorGenero());
    }

    @GetMapping("/estadisticas/distribucion-por-decadas")
    public ResponseEntity <Map<Integer, List<Cancion>>> distribucionPorDecadas(){
        return ResponseEntity.ok(cancionService.distribucionPorDecadas());
    }

    @GetMapping("/ordenar-artista-fecha")
    public ResponseEntity <List<Cancion>> ordenarLista(
        @RequestParam (defaultValue = "0") int pagina,
        @RequestParam (defaultValue = "10") int size) {

            List<Cancion> paginadas = cancionService.ordenarPorArtistaYFecha().stream()
                                        .skip((long) pagina * size)
                                        .limit(size)
                                        .toList();
            return ResponseEntity.ok(paginadas);
        }
}



