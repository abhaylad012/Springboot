package com.example.moviecatelogservice.services;

import com.example.moviecatelogservice.models.CatelogItem;
import com.example.moviecatelogservice.models.Movie;
import com.example.moviecatelogservice.models.Rating;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {
    @Autowired
    RestTemplate restTemplate;


//    @HystrixCommand(fallbackMethod = "getFallbackCatelogItem")
//    public CatelogItem getCatelogItem(Rating rating) {
//        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//        return new CatelogItem(movie.getName(), movie.getDescb(), rating.getRating());
//    }

    @HystrixCommand(fallbackMethod = "getFallbackCatelogItem",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public CatelogItem getCatelogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
        return new CatelogItem(movie.getName(), movie.getDescb(), rating.getRating());
    }

    public CatelogItem getFallbackCatelogItem(Rating rating) {
//        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
        return new CatelogItem("NO movie name", "No movie description ", rating.getRating());
    }
}
