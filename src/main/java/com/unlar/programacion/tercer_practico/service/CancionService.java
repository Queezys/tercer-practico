package com.unlar.programacion.tercer_practico.service;

import com.unlar.programacion.tercer_practico.data.DataLoader;
import com.unlar.programacion.tercer_practico.model.Artista;
import com.unlar.programacion.tercer_practico.model.Cancion;
import com.unlar.programacion.tercer_practico.model.Genero;
import com.unlar.programacion.tercer_practico.strategy.RecomendacionPorDescubrimiento;
import com.unlar.programacion.tercer_practico.strategy.RecomendacionPorGenero;
import com.unlar.programacion.tercer_practico.strategy.RecomendacionPorPopularidad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CancionService {
    private List<Cancion> catalogo = new ArrayList<>();
    private final RecomendacionPorGenero recomendacionPorGenero = new RecomendacionPorGenero();
    private final RecomendacionPorPopularidad recomendacionPorPopularidad = new RecomendacionPorPopularidad();
    private final RecomendacionPorDescubrimiento recomendacionDescubrimiento = new RecomendacionPorDescubrimiento();

    public CancionService(DataLoader dataLoader) {
        this.catalogo = new ArrayList<>(dataLoader.obtenerCanciones());
    }

    public List<Cancion> obtenerCanciones() {
        return this.catalogo;
    }

    public Optional<Cancion> buscarPorId(String id) {
        return catalogo.stream()
                .filter(cancion -> cancion.getId().equals(id))
                .findFirst();
    }

    public Optional<Cancion> reproducir(String id) {
        Optional<Cancion> cancionEncontrada = buscarPorId(id);
        cancionEncontrada.ifPresent(cancion -> cancion.getReproducciones().incrementAndGet());
        return cancionEncontrada;
    }

    public Optional<List<Cancion>> recomendarPorGenero(String id) {
        return buscarPorId(id)
                .map(cancionBase -> recomendacionPorGenero.recomendar(catalogo, cancionBase));
    }

    public List<Cancion> recomendarPorPopularidad() {
    return recomendacionPorPopularidad.recomendar(catalogo, null);
}

    public Optional<List<Cancion>> recomendarPorDescubrimiento(String id){
        return buscarPorId(id)
               .map(cancionBase -> recomendacionDescubrimiento.recomendar(catalogo, cancionBase));
    }

    public List<Cancion> buscarPorTituloYArtista(String titulo, String artista) {
        return catalogo.stream()
                .filter(cancion -> titulo == null
                        || cancion.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .filter(cancion -> artista == null
                        || cancion.getArtista().getNombre().toLowerCase().contains(artista.toLowerCase()))
                .toList();
    }

    //Operaciones con Streams API
    public List<Cancion> buscarConFiltroCompuesto(Genero genero, String nombreArtista, int anioInicio, int anioFin,
            double ratingMin) {
        return catalogo.stream()
                .filter(c -> c.getGenero() == genero)
                .filter(c -> c.getArtista().getNombre().equalsIgnoreCase(nombreArtista))
                .filter(c -> c.getFechaLanzamiento().getYear() >= anioInicio && c.getFechaLanzamiento().getYear() <= anioFin)
                .filter(c -> c.getRating() >= ratingMin)
                .collect(Collectors.toList());
    }

    public List<Cancion> obtenerTop10() {
        return catalogo.stream()
                .sorted(Comparator.comparingInt((Cancion c) -> c.getReproducciones().get()).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    //Estadisticas
    public Map<Genero,Double> promedioDuracionPorGenero() {
        return catalogo.stream()
                .collect(Collectors.groupingBy(Cancion::getGenero, Collectors.averagingInt(Cancion::getDuracionSegundos)));
    }

    

    public Artista artistaMasPopular() {
        return catalogo.stream()
                .max(Comparator.comparingInt(c -> c.getReproducciones().get()))
                .map(Cancion::getArtista)
                .orElse(null);
    }

    public Map<Integer, List<Cancion>> distribucionPorDecadas() {
        return catalogo.stream()
                .collect(Collectors.groupingBy(c -> (c.getFechaLanzamiento().getYear() / 10) * 10));
    }

    //Busquedda
    public Cancion busquedaTituloCancionBinaria(String titulo) {
        List<Cancion> listaOrdenada = catalogo.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        int inicio = 0;
        int fin = listaOrdenada.size() - 1;
        int mitad;

        while (inicio <= fin) {
            mitad = (inicio + fin) / 2;

            int resultadoComparacion = titulo.compareToIgnoreCase(listaOrdenada.get(mitad).getTitulo());

            if (resultadoComparacion == 0) {
                return listaOrdenada.get(mitad);
            } else if (resultadoComparacion < 0) {
                fin = mitad - 1;
            } else {
                inicio = mitad + 1;
            }
        }
        return null;
    }

    public List<Cancion> ordenarPorArtistaYFecha() {
        return catalogo.stream()
                .sorted((Comparator.comparing(Cancion::getArtista))
                        .thenComparing(Cancion::getFechaLanzamiento).reversed())
                .collect(Collectors.toList());
    }

    public List<Cancion> busquedaLineal(Genero genero, int anioFiltro, double ratingFiltro) {
        List<Cancion> resultado = new ArrayList<>();

        for (Cancion cancion : catalogo) {
            if (cancion.getGenero() == genero && cancion.getFechaLanzamiento().getYear() > anioFiltro
                    && cancion.getRating() > ratingFiltro) {
                resultado.add(cancion);
            }
        }
        return resultado;
    }
}
