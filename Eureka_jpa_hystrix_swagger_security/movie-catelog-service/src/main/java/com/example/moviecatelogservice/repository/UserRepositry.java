package com.example.moviecatelogservice.repository;

import com.example.moviecatelogservice.models.UserDb;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositry extends CrudRepository<UserDb, String> {

}
