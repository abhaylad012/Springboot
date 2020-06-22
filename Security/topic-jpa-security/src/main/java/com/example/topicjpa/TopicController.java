package com.example.topicjpa;

import com.example.topicjpa.models.AuthenticationRequest;
import com.example.topicjpa.models.AuthenticationRespose;
import com.example.topicjpa.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TopicController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private TopicService topicService;

    @RequestMapping("/hello")
    public String Hello(){
        return "Hello World";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails= userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationRespose(jwt));
    }

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
