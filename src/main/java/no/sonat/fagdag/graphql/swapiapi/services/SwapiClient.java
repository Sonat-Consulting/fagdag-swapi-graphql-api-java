package no.sonat.fagdag.graphql.swapiapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import no.sonat.fagdag.graphql.swapiapi.YAMLConfig;
import no.sonat.fagdag.graphql.swapiapi.models.Film;
import no.sonat.fagdag.graphql.swapiapi.models.Vehicle;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class SwapiClient {

    private final ObjectMapper mapper = new ObjectMapper();

    private final String filmsUri;
    private final String vehiclesUri;

    public SwapiClient() {
        filmsUri = "https://swapi.dev/api/films/%d/?format=json";
        vehiclesUri = "https://swapi.dev/api/vehicles/%d/?format=json";
    }

    @SneakyThrows
    public Film getFilm(Long filmId) {
        ResponseEntity<String> response = getFilmResponseEntity(String.format(filmsUri, filmId));

        return response.getStatusCode().is2xxSuccessful() ? mapper.readValue(response.getBody(), Film.class) : null;
    }

    @SneakyThrows
    public Vehicle getVehicle(Long vehicleId) {
        ResponseEntity<String> response = getFilmResponseEntity(String.format(vehiclesUri, vehicleId));

        return response.getStatusCode().is2xxSuccessful() ? mapper.readValue(response.getBody(), Vehicle.class) : null;
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
