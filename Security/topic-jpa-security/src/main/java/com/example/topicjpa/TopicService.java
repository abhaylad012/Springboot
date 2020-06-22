package com.example.topicjpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

//    @Autowired
//    private com.example.topicjpa.Topic topic;

    @Autowired
    private TopicRepository topicRepository;

//    private List<com.example.topicjpa.Topic> topics = new ArrayList<>(Arrays.asList(
//            new com.example.topicjpa.Topic("spring", "Spring Framework", "Desc"),
//            new com.example.topicjpa.Topic("java", "Core Java", "JAva desc"),
//            new com.example.topicjpa.Topic("js", "JavaScript", "js desc")
//    ));
//
//    public List<Topic> getAllTopics() {
//
//        return topics;
//    }


//    //    To get all topics  for get request
//    public List<Topic> getAllTopics() {
////        return topics;
////        topicRepository.findAll()
//        List<Topic> topics = new ArrayList<>();
//        topicRepository.findAll().forEach(topics::add);
////        System.out.println(topics);
//        return topics;
//    }
//
//    //    To get topic by id get request
//    public Topic getTopic(String id) {
//////        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
//    }
//
//    //    To add new topic in list post request
//    public void addTopic(com.example.topicjpa.Topic topic) {
////        topics.add(topic);
//    }
//
//    //    To update existing topic by put request
//    public void updateTopic(String id, com.example.topicjpa.Topic topic) {
////        for (int i=0; i < topics.size(); i++){
////            com.example.topicjpa.Topic t = topics.get(i);
////            if (t.getId().equals(id)){
////                topics.set(i, topic);
////                return;
////            }
////        }
//    }
//
//    // To delete topic by id delete request
//    public void deleteTopic(String id) {
//
////        topics.removeIf(t -> t.getId().equals(id) );
//    }

    //    To get all topics  for get request
    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    //    To get topic by id get request
    public Topic getTopic(String id) {

//        return topicRepository.findById(id).get();
        return topicRepository.findById(id).get();
    }

    //    To add new topic in list post request
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    //    To update existing topic by put request
    public void updateTopic(String id,Topic  topic) {
        topicRepository.save(topic);
    }

    // To delete topic by id delete request
    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
