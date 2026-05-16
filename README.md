# TP3: Streaming de Música - Programación III

Este proyecto es una API REST desarrollada con **Spring Boot** que simula una plataforma de streaming de música.

## Características 
* **Normalización del Modelo:** Entidades para Canciones, Artistas y Álbumes.
* **Algoritmos de Recomendación:** Implementación del Patrón *Strategy* para recomendaciones por Género, Popularidad y Descubrimiento.
* **Búsqueda Binaria:** Búsqueda por título de canción ($O(\log n)$ tras ordenamiento).
* **API REST y Documentación:** Controladores HTTP interactivos mediante **Swagger (OpenAPI)**.

## Tecnología
* Java 17 / 21
* Spring Boot 3.x
* Maven
* Swagger UI

## Endpoints de la API (`CancionController`)

La URL base para todos los recursos de canciones es: `http://localhost:8080/api/canciones`

### Consultas y Búsquedas Básicas
* **`GET /api/canciones`**: Obtiene el catálogo completo. Soporta paginación opcional usando parámetros (ej: `?pagina=0&size=10`).
* **`GET /api/canciones/{id}`**: Busca una canción específica por su ID. Devuelve `404 Not Found` si no existe.
* **`GET /api/canciones/top10`**: Lista las 10 canciones más populares de la plataforma.
* **`GET /api/canciones/buscar`**: Búsqueda convencional mediante filtros opcionales de `titulo` y `artista`.

### Algoritmos de Búsqueda y Ordenamiento
* **`GET /api/canciones/busqueda-binaria`**: Realiza una búsqueda optimizada logarítmica $O(\log n)$ por el título exacto de la canción (`?titulo=xxx`).
* **`GET /api/canciones/busqueda-lineal`**: Filtra canciones mediante coincidencia exacta de `genero`, `anio` y `rating`.
* **`GET /api/canciones/filtrar`**: Búsqueda avanzada con un filtro compuesto (`genero`, `artista`, rango de años con `anioInicio`/`anioFin`, y `ratingMin`).
* **`GET /api/canciones/ordenar-artista-fecha`**: Devuelve el catálogo ordenado con un comparador personalizado (por Artista y Año de lanzamiento), incluyendo soporte para paginación.

### Sistema de Recomendaciones (Patrón Strategy)
* **`GET /api/canciones/{id}/recomendaciones/genero`**: Recomienda canciones basándose en la similitud del género del ID ingresado.
* **`GET /api/canciones/recomendaciones/popularidad`**: Sugiere canciones según el ranking global de reproducciones.
* **`GET /api/canciones/{id}/recomendaciones/descubrimiento`**: Algoritmo que filtra géneros similares y prioriza canciones con el mejor rating.

### Interacciones y Estadísticas
* **`POST /api/canciones/{id}/reproducir`**: Incrementa el contador de reproducciones de una canción específica.
* **`GET /api/canciones/estadisticas/artista-mas-popular`**: Analiza el catálogo y devuelve el objeto `Artista` con más reproducciones totales.
* **`GET /api/canciones/estadisticas/promedio-segundos-por-genero`**: Agrupa y calcula la media de duración de las canciones agrupadas por `Genero`.
* **`GET /api/canciones/estadisticas/distribucion-por-decadas`**: Devuelve un mapa con las canciones clasificadas según la década de su lanzamiento.
