package com.unlar.programacion.tercer_practico.strategy;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.unlar.programacion.tercer_practico.model.Cancion;

public class RecomendacionPorPopularidad implements EstrategiaRecomendacion{

    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base){

        return catalogo.stream()
                       .sorted(Comparator.comparingInt((Cancion c) -> c.getReproducciones().get()).reversed())
                       .limit(5)
                       .collect(Collectors.toList());
    }
}
