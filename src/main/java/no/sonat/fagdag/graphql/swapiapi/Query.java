package no.sonat.fagdag.graphql.swapiapi;

import graphql.kickstart.tools.GraphQLQueryResolver;
import no.sonat.fagdag.graphql.swapiapi.models.Film;
import no.sonat.fagdag.graphql.swapiapi.models.Vehicle;
import no.sonat.fagdag.graphql.swapiapi.services.SwapiClient;
import no.sonat.fagdag.graphql.swapiapi.services.SwapiClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
class Query implements GraphQLQueryResolver {

    @Autowired
    SwapiClient swapiClient;

    CompletableFuture<Film> getFilm(Long filmId) {
        return CompletableFuture.supplyAsync(() -> swapiClient.getFilm(filmId));
    }

    CompletableFuture<List<Film>> getAllFilms() {
        return CompletableFuture.supplyAsync(() -> swapiClient.getFilms());
    }

    CompletableFuture<Vehicle> getVehicle(Long vehicleId) {
        return CompletableFuture.supplyAsync(() -> swapiClient.getVehicle(vehicleId));
    }

}