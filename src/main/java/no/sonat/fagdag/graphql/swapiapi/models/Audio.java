package no.sonat.fagdag.graphql.swapiapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public
class Audio {

    private String description;
    private String path;

    public Audio() {}

}