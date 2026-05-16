package com.unlar.programacion.tercer_practico.data;

import com.unlar.programacion.tercer_practico.model.Album;
import com.unlar.programacion.tercer_practico.model.Artista;
import com.unlar.programacion.tercer_practico.model.Cancion;
import com.unlar.programacion.tercer_practico.model.Genero;
import com.unlar.programacion.tercer_practico.model.Productora;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final List<Artista> artistas = new ArrayList<>();
    private final List<Album> albumes = new ArrayList<>();
    private final List<Productora> productoras = new ArrayList<>();
    private final List<Cancion> canciones = new ArrayList<>();

    public DataLoader() {
        cargarDatosIniciales();
    }

    public List<Artista> obtenerArtistas() {
        return artistas;
    }

    public List<Album> obtenerAlbumes() {
        return albumes;
    }

    public List<Productora> obtenerProductoras() {
        return productoras;
    }

    public List<Cancion> obtenerCanciones() {
        return canciones;
    }

    private void cargarDatosIniciales() {
        Artista queen = new Artista("artista-1", "Queen", "Reino Unido");
        Artista acdc = new Artista("artista-2", "AC/DC", "Australia");
        Artista michaelJackson = new Artista("artista-3", "Michael Jackson", "Estados Unidos");
        Artista edSheeran = new Artista("artista-4", "Ed Sheeran", "Reino Unido");
        Artista milesDavis = new Artista("artista-5", "Miles Davis", "Estados Unidos");
        Artista daveBrubeck = new Artista("artista-6", "The Dave Brubeck Quartet", "Estados Unidos");
        Artista daftPunk = new Artista("artista-7", "Daft Punk", "Francia");
        Artista avicii = new Artista("artista-8", "Avicii", "Suecia");
        Artista beethoven = new Artista("artista-9", "Ludwig van Beethoven", "Alemania");
        Artista arcticMonkeys = new Artista("artista-10", "Arctic Monkeys", "Reino Unido");

        artistas.addAll(List.of(
                queen, acdc, michaelJackson, edSheeran, milesDavis, daveBrubeck, daftPunk, avicii, beethoven, arcticMonkeys
        ));

        Productora emi = new Productora("productora-1", "EMI");
        Productora atlantic = new Productora("productora-2", "Atlantic Records");
        Productora epic = new Productora("productora-3", "Epic Records");
        Productora asylum = new Productora("productora-4", "Asylum Records");
        Productora columbia = new Productora("productora-5", "Columbia Records");
        Productora virgin = new Productora("productora-6", "Virgin Records");
        Productora universal = new Productora("productora-7", "Universal Music");
        Productora clasica = new Productora("productora-8", "Musica Clasica Internacional");
        Productora warner = new Productora("productora-9", "Warner Music");
        Productora sony = new Productora("productora-10", "Sony Music");
        Productora indie = new Productora("productora-12", "Independiente");
        Productora dominoRecords = new Productora("productora-9", "Domino Records");
        Productora desertSound = new Productora("productora-10", "Desert Sound Studio");

        productoras.addAll(List.of(
                emi, atlantic, epic, asylum, columbia, virgin, universal, clasica, warner,
                sony, indie, dominoRecords, desertSound
        ));

        Album aNightAtTheOpera = new Album("album-1", "A Night at the Opera", 1975, queen, emi);
        Album backInBlack = new Album("album-2", "Back in Black", 1980, acdc, atlantic);
        Album thriller = new Album("album-3", "Thriller", 1982, michaelJackson, epic);
        Album divide = new Album("album-4", "Divide", 2017, edSheeran, asylum);
        Album kindOfBlue = new Album("album-5", "Kind of Blue", 1959, milesDavis,columbia);
        Album timeOut = new Album("album-6", "Time Out", 1959, daveBrubeck, virgin);
        Album discovery = new Album("album-7", "Discovery", 2001, daftPunk, universal);
        Album levels = new Album("album-8", "Levels", 2011, avicii, universal);
        Album obrasClasicas = new Album("album-9", "Obras Clasicas", 1808, beethoven, clasica);
        Album am = new Album("album-10", "AM", 2013, arcticMonkeys, dominoRecords);
        Album humbug = new Album("album-11", "Humbug", 2009, arcticMonkeys, desertSound);

        albumes.addAll(List.of(
                aNightAtTheOpera, backInBlack, thriller, divide, kindOfBlue, timeOut, discovery,
                levels, obrasClasicas, am, humbug
        ));

        Cancion cancion1 = new Cancion("cancion-1", "Bohemian Rhapsody", queen, aNightAtTheOpera, emi, Genero.ROCK, 354,new AtomicInteger(4000), 5.0, LocalDate.of(1975, 10, 31));
        Cancion cancion2 = new Cancion("cancion-2", "Back in Black", acdc, backInBlack, atlantic, Genero.ROCK, 255,new AtomicInteger(2700), 4.8, LocalDate.of(1980, 7, 25));
        Cancion cancion3 = new Cancion("cancion-3", "Thriller", michaelJackson, thriller, epic, Genero.POP, 357,new AtomicInteger(5444), 4.9, LocalDate.of(1982, 11, 30));
        Cancion cancion4 = new Cancion("cancion-4", "Shape of You", edSheeran, divide, asylum, Genero.POP, 233,new AtomicInteger(3222), 4.5, LocalDate.of(2017, 1, 6));
        Cancion cancion5 = new Cancion("cancion-5", "So What", milesDavis, kindOfBlue, columbia, Genero.JAZZ, 562,new AtomicInteger(7666), 4.7, LocalDate.of(1959, 8, 17));
        Cancion cancion6 = new Cancion("cancion-6", "Take Five", daveBrubeck, timeOut, columbia, Genero.JAZZ, 324,new AtomicInteger(1222), 4.6, LocalDate.of(1959, 9, 21));
        Cancion cancion7 = new Cancion("cancion-7", "One More Time", daftPunk, discovery, virgin, Genero.ELECTRONICA, 320, new AtomicInteger(4555), 4.8, LocalDate.of(2000, 11, 13));
        Cancion cancion8 = new Cancion("cancion-8", "Levels", avicii, levels, universal, Genero.ELECTRONICA, 199,new AtomicInteger(8777), 4.7, LocalDate.of(2011, 10, 28));
        Cancion cancion9 = new Cancion("cancion-9", "Sinfonia No. 5", beethoven, obrasClasicas, clasica, Genero.CLASICA, 420,new AtomicInteger(5444), 5.0, LocalDate.of(1808, 12, 22));
        Cancion cancion10 = new Cancion("cancion-10", "Claro de Luna", beethoven, obrasClasicas, clasica, Genero.CLASICA, 300,new AtomicInteger(3444), 4.9, LocalDate.of(1801, 1, 1));
        Cancion cancion11 = new Cancion("cancion-11","Do I Wanna Know?", arcticMonkeys, am , dominoRecords,Genero.ROCK,272,new AtomicInteger(5777),4.9,LocalDate.of(2013, 6, 19));
        Cancion cancion12 = new Cancion("cancion-12","R U Mine?",arcticMonkeys,am,dominoRecords,Genero.ROCK,201,new AtomicInteger(6440),4.8, LocalDate.of(2012, 2, 27));
        Cancion cancion13 = new Cancion("cancion-13","Arabella",arcticMonkeys, am,dominoRecords,Genero.ROCK,207,new AtomicInteger(9990),4.7, LocalDate.of(2014, 1, 28));
        Cancion cancion14 = new Cancion("cancion-14","Knee Socks",arcticMonkeys,am,dominoRecords,Genero.ROCK,257,new AtomicInteger(2330), 4.6, LocalDate.of(2013, 9, 9));
        Cancion cancion15 = new Cancion("cancion-15", "Snap Out of It", arcticMonkeys, am, dominoRecords, Genero.ROCK, 193, new AtomicInteger(11130), 4.5, LocalDate.of(2013, 9, 9));
        Cancion cancion16 = new Cancion("cancion-16", "Crying Lightning", arcticMonkeys,humbug, desertSound, Genero.ROCK,224, new AtomicInteger(14330),4.8,LocalDate.of(2009, 7, 6));
        Cancion cancion17 = new Cancion("cancion-17","My Propeller", arcticMonkeys, humbug, desertSound,Genero.ROCK,207, new AtomicInteger(3240),4.4, LocalDate.of(2010, 3, 22));
        Cancion cancion18 = new Cancion("cancion-18","Secret Door",arcticMonkeys, humbug,desertSound,Genero.ROCK,223,new AtomicInteger(13220),4.5,LocalDate.of(2009, 8, 19));
        Cancion cancion19 = new Cancion("cancion-19","Cornerstone",arcticMonkeys,humbug,desertSound,Genero.ROCK, 197, new AtomicInteger(12000), 4.7, LocalDate.of(2009, 11, 16));
        Cancion cancion20 = new Cancion("cancion-20","Pretty Visitors",arcticMonkeys,humbug,desertSound,Genero.ROCK,220,new AtomicInteger(12370),4.6,LocalDate.of(2009, 8, 19));


        canciones.addAll(List.of(
            cancion1,cancion2,cancion3,cancion4,cancion5,cancion6,cancion7,cancion8,
            cancion9,cancion10,cancion11,cancion12,cancion13,cancion14,cancion15,cancion16,cancion17,
            cancion18, cancion19, cancion20
        ));

        albumes.forEach(album -> {
            List<Cancion> cancionesDelAlbum = canciones.stream()
                    .filter(cancion -> cancion.getAlbum().equals(album))
                    .toList();
            album.setCanciones(cancionesDelAlbum);
        });

        productoras.forEach(productora -> {
            List<Album> albumesDeLaProductora = albumes.stream()
                    .filter(album -> album.getProductora().equals(productora))
                    .toList();
            productora.setAlbumes(albumesDeLaProductora);
        
            List<Artista> artistasDeLaProductora = albumesDeLaProductora.stream()
                    .map(Album::getArtista)
                    .distinct()
                    .toList();
            productora.setArtistas(artistasDeLaProductora);
        });
    }
}

    