package com.example.moviecatelogservice.services;

import com.example.moviecatelogservice.models.UserDb;
import com.example.moviecatelogservice.repository.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserDbService {


    @Autowired
    private UserRepositry userRepositry;

    public List<UserDb> getAllUsers(){
        List<UserDb> userDb =new ArrayList<>();
        userRepositry.findAll().forEach(userDb::add);
        return userDb;
    }


}
