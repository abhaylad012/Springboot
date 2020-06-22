package com.example.moviecatelogservice.models;

public class Movie {

    private String defId;
    private String movieId;
    private String name;
    private String descb;



    public Movie() {

    }

    public Movie(String movieId, String name, String descb) {
        this.movieId = movieId;
        this.name = name;
        this.descb = descb;
    }

    public String getDescb() {
        return descb;
    }

    public String getDefId() {
        return defId;
    }

    public void setDescb(String descb) {
        this.descb = descb;
    }

    public void setDefId(String defId) {
        this.defId = defId;
    }

//    public Movie(String movieId, String name) {
//        this.movieId = movieId;
//        this.name = name;
//    }

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