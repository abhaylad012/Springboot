package com.example.moviecatelogservice.models;

public class CatelogItem {

    private String name;
    private String desc;
    private int rating;

    public CatelogItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CatelogItem{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", rating=" + rating +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}