package com.unlar.programacion.tercer_practico.service;

import com.unlar.programacion.tercer_practico.data.DataLoader;
import com.unlar.programacion.tercer_practico.model.Productora;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductoraService {

    private final List<Productora> productoras;

    public ProductoraService(DataLoader dataLoader) {
        this.productoras = new ArrayList<>(dataLoader.obtenerProductoras());
    }

    public List<Productora> obtenerProductoras() {
        return productoras;
    }

    public Optional<Productora> buscarPorId(String id) {
        return productoras.stream()
                .filter(productora -> productora.getId().equals(id))
                .findFirst();
    }

    public List<Productora> buscarPorNombre(String nombre) {
        return productoras.stream()
                .filter(productora -> productora.getNombre().equalsIgnoreCase(nombre))
                .toList();
    }
}
