package com.example.topicjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    //    To get all topics get request
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    //    To get topic by id get request
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }
//
//    //    To add new topic in list post request
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }
//
//    //    To update existing topic by put request
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
    }
//
//    // To delete topic by id delete request
    @RequestMapping(method = RequestMethod.DELETE,value ="/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
         topicService.deleteTopic(id);
    }
//
//

    //    Testing of app
//    @RequestMapping("/topics")
//    public List<Topic> getAllTopics(){
//
//        return Arrays.asList(
//                new Topic("spring", "Spring Framework", "Desc"),
//                new Topic("java", "Core Java", "JAva desc"),
//                new Topic("js","JavaScript","js desc")
//        );
//    }


}
