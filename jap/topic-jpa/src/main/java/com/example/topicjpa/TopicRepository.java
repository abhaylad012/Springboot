package com.example.topicjpa;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {


//    Topic findOne(String id);
}
