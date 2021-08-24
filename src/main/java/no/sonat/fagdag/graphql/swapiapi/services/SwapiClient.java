package no.sonat.fagdag.graphql.swapiapi.services;

import no.sonat.fagdag.graphql.swapiapi.models.Film;
import no.sonat.fagdag.graphql.swapiapi.models.Vehicle;

import java.util.List;

public interface SwapiClient {

    Film getFilm(Long filmId);
    Vehicle getVehicle(Long vehicleId);
    List<Film> getFilms();

}
