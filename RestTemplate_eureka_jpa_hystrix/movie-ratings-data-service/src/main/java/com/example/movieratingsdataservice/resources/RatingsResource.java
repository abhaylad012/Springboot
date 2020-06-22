package com.example.movieratingsdataservice.resources;


import com.example.movieratingsdataservice.models.Rating;
import com.example.movieratingsdataservice.models.UserRating;
import com.example.movieratingsdataservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @Autowired
    private RatingRepository ratingRepository;

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

//    @RequestMapping("users/{userId}")
//    public List<Rating> getUserRating(@PathVariable("userId") String userId) {
//
//        List<Rating> ratings = Arrays.asList(
//                new Rating("1", 7),
//                new Rating("2", 6),
//                new Rating("3", 8)
//        );
////        return new Rating( movieId, 4);
//        return ratings;
//    }

//    @RequestMapping("users/{userId}")
//    public UserRating getUserRating(@PathVariable("userId") String userId) {
//
//        List<Rating> ratings = Arrays.asList(
//                new Rating("1", 7),
//                new Rating("2", 6),
//                new Rating("3", 8)
//        );
//
//        UserRating userRating = new UserRating();
//        userRating.setUserRating(ratings);
//
//        return userRating;
//    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {

//        List<Rating> ratings = Arrays.asList(
//                new Rating("1", 7),
//                new Rating("2", 6),
//                new Rating("3", 8)
//        );
//        UserRating userRating = new UserRating();
        List<Rating> ratings = new ArrayList<>();

        ratingRepository.findAll().forEach(ratings::add);
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;
    }


}
