package no.sonat.fagdag.graphql.swapiapi;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.SneakyThrows;
import no.sonat.fagdag.graphql.swapiapi.models.Film;
import no.sonat.fagdag.graphql.swapiapi.models.Audio;
import no.sonat.fagdag.graphql.swapiapi.models.Review;
import no.sonat.fagdag.graphql.swapiapi.models.Vehicle;
import no.sonat.fagdag.graphql.swapiapi.services.AudioServiceImpl;
import no.sonat.fagdag.graphql.swapiapi.services.FakeReviewClient;
import no.sonat.fagdag.graphql.swapiapi.services.SwapiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
class Query implements GraphQLQueryResolver {

    @Autowired
    SwapiClient swapiClient;

    @Autowired
    AudioServiceImpl audioService;

    final List<Review> reviews = new ArrayList<>();

    public Query() {
        reviews.addAll(FakeReviewClient.getReviews());
    }

    CompletableFuture<Film> getFilm(Long filmId) {
        return CompletableFuture.supplyAsync(() -> swapiClient.getFilm(filmId));
    }

    CompletableFuture<List<Film>> getFilms() {
        return CompletableFuture.supplyAsync(() -> swapiClient.getFilms());
    }

    CompletableFuture<Vehicle> getVehicle(Long vehicleId) {
        return CompletableFuture.supplyAsync(() -> swapiClient.getVehicle(vehicleId));
    }

    CompletableFuture<Audio> getAudio() {

        return CompletableFuture.supplyAsync(() -> audioService.playRandom()
        );
    }

    @SneakyThrows
    CompletableFuture<List<Review>> getReviews() {
        return CompletableFuture.supplyAsync(() -> reviews);
    }


}