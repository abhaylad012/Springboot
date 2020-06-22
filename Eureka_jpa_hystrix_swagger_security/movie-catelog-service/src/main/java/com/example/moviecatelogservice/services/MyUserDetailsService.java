package com.example.moviecatelogservice.services;

import com.example.moviecatelogservice.models.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

//    @Autowired
//    private UserDb userDb;
//
//    @Autowired
//    private UserDbService userDbService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new User("abhay","123", new ArrayList<>());
//        List<UserDb> userDb = userDbService.getAllUsers();
//        UserDb userDb1 = userDbService.getAllUsers().Collections.singletonList();

        return new User("abhay","123", new ArrayList<>());

    }
}
