package com.example.topicjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topic {

//    For creating auto increamented values
    //    @GeneratedValue(strategy= GenerationType.AUTO)

    @Id
    private String id;

    private String name;
    private String descb;



    public Topic(){

    }

    public Topic(String id, String name, String descb) {
        this.id = id;
        this.name = name;
        this.descb = descb;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdescb() {
        return descb;
    }

    public void setdescb(String descb) {
        this.descb = descb;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", descb='" + descb + '\'' +
                '}';
    }
}
