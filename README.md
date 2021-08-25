# Getting Started
This GraphQL API consumes [SWAPI - The Star Wars API](https://swapi.dev/documentation).

### Running from command line
```
./gradlew bootRun
```

###### Common issues: 

"Permission denied" on Mac, Ubuntu, etc. please run the following in terminal:
```
chmod +x gradlew
```

### Install following to get started
_Set enviorment variables per instructions for your operating system._
* [Java SE Development Kit 8u301](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* [Maven](https://maven.apache.org/)
* [Gradle](https://gradle.org/install/)
* [IntelliJ Plugin for GraphQL](https://plugins.jetbrains.com/plugin/8097-js-graphql)

### Playing with the API
_Open these in your favourite browser after running the project._
* [Playground](http://localhost:9000/playground)
* [Voyager](http://localhost:9000/voyager)

### Additional Links
These additional references should also help you:
* [Explore GraphQl Documentation](https://www.graphql.com/)
* [About GraphQL Spring Boot](https://www.graphql-java-kickstart.com/spring-boot/)

### Example queries
Add these queries to Playground after the project is up and running.
```
# All films with reviews
{
  films {
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

```
# Play and describe a sound effect
{
audio {description}
}
```
