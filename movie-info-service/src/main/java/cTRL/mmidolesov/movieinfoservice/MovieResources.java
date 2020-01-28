package cTRL.mmidolesov.movieinfoservice;

import cTRL.mmidolesov.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieResources {

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") final String movieId){
        return new Movie(movieId, "Test name1");
    }

}
