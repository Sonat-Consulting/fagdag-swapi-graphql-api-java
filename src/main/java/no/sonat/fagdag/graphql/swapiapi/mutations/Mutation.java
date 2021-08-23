package no.sonat.fagdag.graphql.swapiapi.mutations;


import graphql.kickstart.tools.GraphQLMutationResolver;
import no.sonat.fagdag.graphql.swapiapi.models.Review;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    public Review createReview(Review review) {
        // nothing to see here yet

        return review;
    }
}
