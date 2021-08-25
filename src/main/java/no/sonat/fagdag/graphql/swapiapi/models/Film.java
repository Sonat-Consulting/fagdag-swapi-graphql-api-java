package no.sonat.fagdag.graphql.swapiapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Film implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("episode_id")
    private Long episodeId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("opening_crawl")
    private String openingCrawl;

    @JsonProperty("director")
    private String director;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("characters")
    private List<String> characters;

    @JsonProperty("planets")
    private List<String> planets;

    @JsonProperty("species")
    private List<String> species;

    @JsonProperty("starships")
    private List<String> starships;

    @JsonProperty("vehicles")
    private List<String> vehicles;

    @JsonProperty("vehicle")
    private List<Vehicle> vehicleList;

    @JsonProperty("reviews")
    private List<Review> reviews;

    // Jackson noargs
    public Film() {}

    public Film(Long id) {
        this.id = id;
    }


}