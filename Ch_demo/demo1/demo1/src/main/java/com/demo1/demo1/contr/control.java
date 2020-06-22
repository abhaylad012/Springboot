package com.demo1.demo1.contr;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo1.demo1.model.Movie;

@RequestMapping("/demo1")
@RestController
public class control {

	@RequestMapping("/movie/{movieId}")
	public Movie getmovies(@PathVariable("movieId") String movieId) {
		return new Movie(movieId,"testname", "hekko");
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
}
