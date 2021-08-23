package no.sonat.fagdag.graphql.swapiapi.resolvers;

import graphql.kickstart.tools.GraphQLResolver;
import no.sonat.fagdag.graphql.swapiapi.models.*;
import no.sonat.fagdag.graphql.swapiapi.services.FakeReviewClient;
import no.sonat.fagdag.graphql.swapiapi.services.SwapiClient;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

@Component
class FilmResolver implements GraphQLResolver<Film> {

    final List<Review> reviews = new ArrayList<>();
    final SwapiClient swapiClient = new SwapiClient();

    FilmResolver() {
        reviews.addAll(FakeReviewClient.getReviews());
    }

    public List<Vehicle> getVehicle(Film film) {
        List<Vehicle> vehicles = new ArrayList<>();

        for (String vehicle:film.getVehicles()) {
            Long vehicleId = Long.valueOf(vehicle.replaceAll("[^0-9]", ""));
            vehicles.add(swapiClient.getVehicle(vehicleId));
        }

        film.setVehicleList(vehicles);

        return vehicles;
    }

    public List<Review> getReviews(Film film) {
        return reviews.stream()
                .filter(x -> film.getEpisodeId().equals(x.getId()))
                .collect(Collectors.toList());
    }

}
