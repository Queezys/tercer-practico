package com.unlar.programacion.tercer_practico.strategy;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.unlar.programacion.tercer_practico.model.Cancion;

public class RecomendacionPorGenero implements EstrategiaRecomendacion {
    
    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {
        return catalogo.stream()
                .filter(c -> c.getGenero() == base.getGenero())
                .filter(c -> !c.getId().equals(base.getId()))
                .sorted(Comparator.comparing(Cancion::getRating).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}
