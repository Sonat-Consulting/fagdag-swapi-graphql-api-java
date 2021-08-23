package no.sonat.fagdag.graphql.swapiapi.services;

import lombok.SneakyThrows;
import no.sonat.fagdag.graphql.swapiapi.models.Film;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapiClientTest {

    @Test
    void getFilm() {
        SwapiClient swapiClient = new SwapiClient();

        Film film = swapiClient.getFilm(1L);

        assertNotNull(film);
        assertEquals(4, film.getEpisodeId());

    }

    @SneakyThrows
    @Test
    void resolveUri() {
        String url = "https://swapi.dev/api/people/12/";
        assertEquals("12", url.replaceAll("[^0-9]", ""));

    }
}