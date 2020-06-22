package com.example.movieinfoservice.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
//    @GeneratedValue(strategy= GenerationType.AUTO)

//    @Id
//    private String defId;
    @Id
    private String movieId;
    private String name;

    public Movie() {
    }

//    public String getDefId() {
//        return defId;
//    }
//
//    public void setDefId(String defId) {
//        this.defId = defId;
//    }

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
