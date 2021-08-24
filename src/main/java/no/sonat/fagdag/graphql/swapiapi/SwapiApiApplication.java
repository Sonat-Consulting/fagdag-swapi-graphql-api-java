package no.sonat.fagdag.graphql.swapiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class SwapiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwapiApiApplication.class, args);
	}

}
