package no.sonat.fagdag.graphql.swapiapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Vehicle {

    // jackson noargs
    public Vehicle() {}

    // Search constructor
    public Vehicle(Long id) {
        this.id = id;
    }

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("model")
    private String model;

    @JsonProperty("vehicle_class")
    private String vehicleClass;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("length")
    private String length;

    @JsonProperty("cost_in_credits")
    private String costInCredits;

    @JsonProperty("passengers")
    private String passengers;

    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    @JsonProperty("consumables")
    private String consumables;

    @JsonProperty("starship_class")
    private String starshipClass;

    @JsonProperty("crew")
    private String crew;

    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;

    @JsonProperty("MGLT")
    private String MGLT;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("pilots")
    private List<String> pilots;

}

