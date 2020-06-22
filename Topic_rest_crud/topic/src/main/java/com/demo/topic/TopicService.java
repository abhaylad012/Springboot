package com.demo.topic;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Desc"),
            new Topic("java", "Core Java", "JAva desc"),
            new Topic("js", "JavaScript", "js desc")
    ));


    //    To get all topics  for get request
    public List<Topic> getAllTopics() {
        return topics;
    }

    //    To get topic by id get request
    public Topic getTopic(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    //    To add new topic in list post request
    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    //    To update existing topic by put request
    public void updateTopic(String id, Topic topic) {
        for (int i=0; i < topics.size(); i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    // To delete topic by id delete request
    public void deleteTopic(String id) {

        topics.removeIf(t -> t.getId().equals(id) );
    }
}
