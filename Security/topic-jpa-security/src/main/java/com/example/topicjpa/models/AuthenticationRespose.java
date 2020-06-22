package com.example.topicjpa.models;

public class AuthenticationRespose {

    private  final String jwt;

    public String getJwt() {
        return jwt;
    }

    public AuthenticationRespose(String jwt) {
        this.jwt = jwt;
    }
}
