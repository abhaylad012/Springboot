package com.example.moviecatelogservice.services;


import com.example.moviecatelogservice.models.Rating;
import com.example.moviecatelogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfo {

    @Autowired
    RestTemplate restTemplate;

//    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
//    public UserRating getUserRating(@PathVariable("userId") String userId) {
//        return restTemplate.getForObject("http://movie-ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
//    }

    @HystrixCommand(fallbackMethod = "getFallbackUserRating",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })

    public UserRating getUserRating(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://movie-ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
    }

    public UserRating getFallbackUserRating(@PathVariable("userId") String userId) {
//        return restTemplate.getForObject("http://movie-ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
//        return "Information about" +userId +" is not currently available";
        UserRating userRating = new UserRating();
//        userRating.setUserId(userId);
        userRating.setUserRating(Arrays.asList(
                new Rating("No movie Id currently available", userId, 0)
        ));
        return userRating;
    }
}
