package no.sonat.fagdag.graphql.swapiapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class FilmEnvelope {

    @JsonProperty("count")
    private int count;

    @JsonProperty("next")
    private String next;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("results")
    private List<Film> films;

    // Jackson noargs
    public FilmEnvelope() {}

}
