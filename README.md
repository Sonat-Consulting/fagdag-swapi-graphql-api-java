# Getting Started
This GraphQL API consumes [SWAPI - The Star Wars API](https://swapi.dev/documentation).

### Running from command line
./gradlew bootRun

### Install following to get started
* [Java SE Development Kit 8u301](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* [Maven](https://maven.apache.org/)

### Playing with the API
* [Playground](http://localhost:9000/playground)
* [Voyager](http://localhost:9000/voyager)

### Additional Links
These additional references should also help you:
* [About GraphQL Spring Boot](https://www.graphql-java-kickstart.com/spring-boot/)

### Example queries

```
# All films with reviews
{
  allFilms {
    episodeId
    title
    reviews {
      username
      rating
    }
  }
}
```


```
#Film episode 4 with review
{
  film(id: 4) {
    episodeId,
    title,
    openingCrawl,
    director,
    producer,
    releaseDate,
    reviews {
      username
      rating
    }
  }
}
```


```
#Film episode 4 with vehicle and review
{
  film(id: 4) {
    episodeId,
    title,
    openingCrawl,
    director,
    producer,
    releaseDate,
    vehicle {
      name
      passengers
      cargo_capacity
      maxAtmospheringSpeed
      }
    reviews {
      username
      rating
    }
  }
}
```

```
# Vehicle with properties
{
  vehicle(id: 8) {
      name
      passengers
      cargo_capacity
      maxAtmospheringSpeed
  }
}
```
