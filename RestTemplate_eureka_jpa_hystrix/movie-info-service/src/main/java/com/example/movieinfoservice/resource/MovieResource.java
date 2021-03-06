package com.example.movieinfoservice.resource;


import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private MovieRepository movieRepository;


    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {

        //List<Movie> movie = Arrays.asList()
//        return new Movie(movieId, "Test Name for");

        //by using crud of jpa fetch all movies info db
        return movieRepository.findById(movieId).get();
        // have to create interface for crud repo


    }


}
