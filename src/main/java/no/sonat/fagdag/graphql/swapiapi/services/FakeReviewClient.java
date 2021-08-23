package no.sonat.fagdag.graphql.swapiapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import no.sonat.fagdag.graphql.swapiapi.models.Film;
import no.sonat.fagdag.graphql.swapiapi.models.Review;
import no.sonat.fagdag.graphql.swapiapi.models.Vehicle;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static java.util.Collections.replaceAll;
import static java.util.Collections.singletonList;

public class FakeReviewClient {

    @SneakyThrows
    public static List<Review> getReviews() {
        final List<Review> reviews = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            reviews.add(new Review(getRandomFilmId(), getRandomUser(), getRandomDice()));
        }

        return reviews;
    }

    private static long getRandomFilmId() {
        return (new java.util.Random().nextLong() % (6 - 1)) + 1;
    }

    private static int getRandomDice() {
        return  (new java.util.Random().nextInt(6) + 1);
    }

    private static String getRandomUser() {
        Random rand = new Random();
        List<String> a = Arrays.asList("strong", "manly", "hairy", "messy", "dedicated", "short", "tilted", "tiny");
        List<String> c = Arrays.asList("", "_", "-");
        List<String> s = Arrays.asList("cat", "dog", "man", "obie", "force", "obiewan", "luke", "skywalker");

        return String.format("%s%s%s", a.get(rand.nextInt(a.size())), c.get(rand.nextInt(c.size())), s.get(rand.nextInt(s.size())));
    }
}
