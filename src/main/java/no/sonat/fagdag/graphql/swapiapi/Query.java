package no.sonat.fagdag.graphql.swapiapi;

import graphql.kickstart.tools.GraphQLQueryResolver;
import no.sonat.fagdag.graphql.swapiapi.models.Film;
import no.sonat.fagdag.graphql.swapiapi.models.Vehicle;
import no.sonat.fagdag.graphql.swapiapi.services.SwapiClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
class Query implements GraphQLQueryResolver {

    SwapiClient swapiClient = new SwapiClient();

    CompletableFuture<Film> getFilm(Long filmId) {
        return CompletableFuture.supplyAsync(() -> swapiClient.getFilm(filmId));
    }

    CompletableFuture<Vehicle> getVehicle(Long vehicleId) {
        return CompletableFuture.supplyAsync(() -> swapiClient.getVehicle(vehicleId));
    }

}