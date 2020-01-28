package cTRL.mmidolesov.moviecatalogservice.services;

import cTRL.mmidolesov.moviecatalogservice.models.CatalogItem;
import cTRL.mmidolesov.moviecatalogservice.models.Movie;
import cTRL.mmidolesov.moviecatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieInfo {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalog")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service:8082/movies/" +
                rating.getMovieId(), Movie.class);

        return new CatalogItem(movie.getName(), "Test desc", rating.getRating());
    }

    public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") final String userId){
        return Arrays.asList(new CatalogItem("No movie", "", 0));
    }

}
