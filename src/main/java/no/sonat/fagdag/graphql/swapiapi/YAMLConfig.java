package no.sonat.fagdag.graphql.swapiapi;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@ConfigurationProperties(prefix="swapi")
//@EnableConfigurationProperties(Config.class)
//@Configuration
//@Component


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="swapi")
public class YAMLConfig {

    private String filmsUri;

    public String getFilmsUri() {
        return filmsUri;
    }

    public void setFilmsUri(String filmsUri) {
        this.filmsUri = filmsUri;
    }
}