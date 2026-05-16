package com.unlar.programacion.tercer_practico.controller;

import com.unlar.programacion.tercer_practico.model.Productora;
import com.unlar.programacion.tercer_practico.service.ProductoraService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productoras")
public class ProductoraController {

    private final ProductoraService productoraService;

    public ProductoraController(ProductoraService productoraService) {
        this.productoraService = productoraService;
    }

    @GetMapping
    public ResponseEntity<List<Productora>> listarTodas(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int size) {

        List<Productora> productoras = productoraService.obtenerProductoras().stream()
                .skip((long) pagina * size)
                .limit(size)
                .toList();

        return ResponseEntity.ok(productoras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productora> buscarPorId(@PathVariable String id) {
        return productoraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Productora>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(productoraService.buscarPorNombre(nombre));
    }
}
