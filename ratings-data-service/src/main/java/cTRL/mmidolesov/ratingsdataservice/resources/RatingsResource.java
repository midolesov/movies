package cTRL.mmidolesov.ratingsdataservice.resources;

import cTRL.mmidolesov.ratingsdataservice.models.Rating;
import cTRL.mmidolesov.ratingsdataservice.models.UserRating;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/ratingsdata")
public class RatingsResource {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") final String movieId){
        return new Rating(movieId, 5);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable("userId") final String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("4567", 3)
        );

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }

}
