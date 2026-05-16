package com.unlar.programacion.tercer_practico.strategy;
import java.util.List;
import com.unlar.programacion.tercer_practico.model.Cancion;

public interface EstrategiaRecomendacion {
    List<Cancion> recomendar(List<Cancion> catalogo, Cancion base);
}
