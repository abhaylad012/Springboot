package com.example.moviecatelogservice.resources;


import com.example.moviecatelogservice.models.CatelogItem;
import com.example.moviecatelogservice.models.Movie;
import com.example.moviecatelogservice.models.Rating;
import com.example.moviecatelogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//By using only rest Template or WebClient

//@RestController
//@RequestMapping("/catelog")
//public class MovieCatelogResource {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private WebClient.Builder webClientBUilder;
//
//    @RequestMapping("/{userId}")
//    public List<CatelogItem> getCatelog(@PathVariable("userId") String userId) {
////        WebClient.Builder builder = WebClient.builder();
//
//
////Since it is called after every rest request it is initiallized as bean
//// and then autowired n acalled only once
////        RestTemplate restTemplate = new RestTemplate();
//
////        Movie movie = restTemplate.getForObject("http://localhost:8082/movies/7",Movie.class);
//
//        //get all rated movies IDs
//
//////        hardcoded values which should come from other rating data service
////        List<Rating> ratings = Arrays.asList(
////                new Rating("1", 7),
////                new Rating("2", 6),
////                new Rating("3", 8)
////        );
//        UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);
//
//        return ratings.getUserRating().stream().map(rating -> {
//            //For RestTemplate
//            //For each movie id , call movie info service and get details
//            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
////By using web client
////            Movie movie = webClientBUilder.build()
////                    .get()
////                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
////                    .retrieve()
////                    .bodyToMono(Movie.class)
////                    .block();
//            // put them all together
//            return new CatelogItem(movie.getName(), "harcoded values", rating.getRating());
//        }).collect(Collectors.toList());
//        //For each movie  ID, call movie info service and get details
//
//
////        //put them all together
////        return Collections.singletonList(
////                new CatelogItem( "abhay",  "ghj",  9)
////        );
//    }
//}

@RestController
@RequestMapping("/catelog")
public class MovieCatelogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBUilder;

    @RequestMapping("/{userId}")
    public List<CatelogItem> getCatelog(@PathVariable("userId") String userId) {
//        WebClient.Builder builder = WebClient.builder();


//Since it is called after every rest request it is initiallized as bean
// and then autowired n acalled only once
//        RestTemplate restTemplate = new RestTemplate();

//        Movie movie = restTemplate.getForObject("http://localhost:8082/movies/7",Movie.class);

        //get all rated movies IDs

////        hardcoded values which should come from other rating data service
//        List<Rating> ratings = Arrays.asList(
//                new Rating("1", 7),
//                new Rating("2", 6),
//                new Rating("3", 8)
//        );
        UserRating ratings = restTemplate.getForObject("http://movie-ratings-data-service/ratingsdata/users/" + userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            //For RestTemplate
            //For each movie id , call movie info service and get details
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//By using web client
//            Movie movie = webClientBUilder.build()
//                    .get()
//                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();
            // put them all together
//            return new CatelogItem(movie.getName(), "harcoded values", rating.getRating());
            return new CatelogItem(movie.getName(), "harcoded values", rating.getRating());

        }).collect(Collectors.toList());
        //For each movie  ID, call movie info service and get details


//        //put them all together
//        return Collections.singletonList(
//                new CatelogItem( "abhay",  "ghj",  9)
//        );
    }
}

