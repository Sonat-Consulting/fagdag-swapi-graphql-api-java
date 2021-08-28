package no.sonat.fagdag.graphql.swapiapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import no.sonat.fagdag.graphql.swapiapi.models.Film;
import no.sonat.fagdag.graphql.swapiapi.models.FilmEnvelope;
import no.sonat.fagdag.graphql.swapiapi.models.Vehicle;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class SwapiClientImpl implements SwapiClient {

    private final ObjectMapper mapper = new ObjectMapper();

    private final String filmsUri;
    private final String allFilmsUri;
    private final String vehiclesUri;

    public SwapiClientImpl() {
        filmsUri = "https://swapi.dev/api/films/%d/?format=json";
        allFilmsUri = "https://swapi.dev/api/films/?format=json";
        vehiclesUri = "https://swapi.dev/api/vehicles/%d/?format=json";
    }

    @SneakyThrows
    @Cacheable("film")
    public Film getFilm(Long filmId) {
        ResponseEntity<String> response = getFilmResponseEntity(String.format(filmsUri, filmId));
        System.out.println(String.format("Cache miss: Film %d ", filmId));

        return response.getStatusCode().is2xxSuccessful() ? mapper.readValue(response.getBody(), Film.class) : null;
    }

    @SneakyThrows
    @Cacheable("vehicle")
    public Vehicle getVehicle(Long vehicleId) {
        ResponseEntity<String> response = getFilmResponseEntity(String.format(vehiclesUri, vehicleId));
        System.out.println(String.format("Cache miss: Vehicle %d ", vehicleId));

        return response.getStatusCode().is2xxSuccessful() ? mapper.readValue(response.getBody(), Vehicle.class) : null;
    }

    @SneakyThrows
    @Cacheable("films")
    public List<Film> getFilms() {
        ResponseEntity<String> response = getFilmResponseEntity(allFilmsUri);
        System.out.println("Cache miss: all films");

        return response.getStatusCode().is2xxSuccessful() ? mapper.readValue(response.getBody(), FilmEnvelope.class).getFilms() : new ArrayList<>();
    }

    @NotNull
    private static ResponseEntity<String> getFilmResponseEntity(String url) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }


}
