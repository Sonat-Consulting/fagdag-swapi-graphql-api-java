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

## Assignment 1
_We will query the server with GraphQL queries_
1. Query for all films with fields title and producer
2. Query for all films with fields title, openingcrawl and releaseDate
3. Query for all films with fields title, vehicles (vehicles with at least two subfields: model and manufaturer).
4. Query for all reviews
5. Query for film with id 3
6. Give a name to the query from assignment 5
7. Change the value 3 with a variable

## Assignment 2
We will fill in code to get the GraphQL API to work as it did in assignment 1.

Before we continue, please change branch
```
git branch del-2
```
