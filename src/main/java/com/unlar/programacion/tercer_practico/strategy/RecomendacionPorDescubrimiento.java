package com.unlar.programacion.tercer_practico.strategy;
import java.util.Comparator;
import java.util.List;
import com.unlar.programacion.tercer_practico.model.Cancion;

public class RecomendacionPorDescubrimiento implements EstrategiaRecomendacion {

    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {
        return catalogo.stream()
                .filter(c -> !c.equals(base))
                .filter(c -> c.getGenero() != base.getGenero())
                .filter(c -> c.getReproducciones().get() < 1000)
                .sorted(Comparator.comparing(Cancion::getRating).reversed())
                .limit(10)
                .toList();
    }
}