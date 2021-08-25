package no.sonat.fagdag.graphql.swapiapi.services;

import lombok.SneakyThrows;
import no.sonat.fagdag.graphql.swapiapi.models.Film;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SwapiClientTest {

    private final SwapiClientImpl swapiClientImpl = new SwapiClientImpl();

    @Test
    void getFilm() {
        Film film = swapiClientImpl.getFilm(1L);

        assertNotNull(film);
        assertEquals(4, film.getEpisodeId());

    }

    @Test
    void getFilms() {
        List<Film> filmList= swapiClientImpl.getFilms();

        assertNotNull(filmList);
        assert(filmList.size() >= 1);
    }



    @SneakyThrows
    @Test
    void resolveUri() {
        String url = "https://swapi.dev/api/people/12/";
        assertEquals("12", url.replaceAll("[^0-9]", ""));

    }
}