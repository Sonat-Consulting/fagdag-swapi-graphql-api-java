package no.sonat.fagdag.graphql.swapiapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public
class Review {

    private Long id;
    private String username;
    private int rating;

    public Review() {}
    public Review(Long id) {
        this.id = id;
    }
}