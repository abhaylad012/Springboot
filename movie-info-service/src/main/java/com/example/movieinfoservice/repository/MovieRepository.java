package com.example.movieinfoservice.repository;

import com.example.movieinfoservice.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository  extends CrudRepository<Movie, String> {
}
