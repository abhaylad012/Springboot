package com.example.moviecatelogservice.resources;


import com.example.moviecatelogservice.models.CatelogItem;
import com.example.moviecatelogservice.models.Movie;
import com.example.moviecatelogservice.models.Rating;
import com.example.moviecatelogservice.models.UserRating;
import com.example.moviecatelogservice.services.MovieInfo;
import com.example.moviecatelogservice.services.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//By using only rest Template or WebClient

@RibbonClient(name="movie-catelog-service")
@RestController
@RequestMapping("/catelog")
public class MovieCatelogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBUilder;

    @Autowired
    MovieInfo movieInfo;

    @Autowired
    UserRatingInfo userRatingInfo;

//    @HystrixCommand(fallbackMethod = "getFallbackCatelog")
//    @RequestMapping("/{userId}")
//    public List<CatelogItem> getCatelog(@PathVariable("userId") String userId) {
//
//        UserRating ratings = restTemplate.getForObject("http://movie-ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
//
//        return ratings.getUserRating().stream().map(rating -> {
//            //For RestTemplate
//            //For each movie id , call movie info service and get details
//            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//
//            return new CatelogItem(movie.getName(), movie.getDescb(), rating.getRating());
//
//        }).collect(Collectors.toList());
//
//    }
//
//    public List<CatelogItem> getFallbackCatelog(@PathVariable("userId") String userId) {
//
//        return Arrays.asList(new CatelogItem("No name", "No description", 0 ));
//    }

    @RequestMapping(value="/{userId}", method = RequestMethod.GET)
    public List<CatelogItem> getCatelog(@PathVariable("userId") String userId) {

        UserRating ratings = userRatingInfo.getUserRating(userId);

        return ratings.getUserRating().stream().map(rating -> {

            return movieInfo.getCatelogItem(rating);

        }).collect(Collectors.toList());

    }


}

