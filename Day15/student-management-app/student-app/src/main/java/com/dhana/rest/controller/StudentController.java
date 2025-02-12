package com.dhana.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private final RestTemplate restTemplate;

    public StudentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${get.receive.url}")
    String receiveGetUrl;    //   http://localhost:8080/student/read

    @Value("${post.receive.url}")
    String receivePostUrl;    //   http://localhost:8080/student/save

    @Value("${put.receive.url}")
    String receivePutUrl;    //   http://localhost:8080/student/updateAge

    @Value("${delete.receive.url}")
    String receiveDeleteUrl;    //   http://localhost:8080/student/delete


    @PostMapping("/post")
    public String save() {
        ResponseEntity<String> response = restTemplate.exchange(receivePostUrl, HttpMethod.POST,null,String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return response.getBody();
    }
    @GetMapping("/get")
    public String getAllStudents() {
        ResponseEntity<String> response
                = restTemplate.exchange(receiveGetUrl, HttpMethod.GET, null,String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return response.getBody();
    }
    @PutMapping("/put")
    public String updateAge() {
        ResponseEntity<String> response
                = restTemplate.exchange(receivePutUrl, HttpMethod.GET, null, String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return response.getBody();
    }
    @DeleteMapping("/delete")
    public String delete() {
        ResponseEntity<String> response
                = restTemplate.exchange(receiveDeleteUrl, HttpMethod.GET, null, String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return response.getBody();
    }
}