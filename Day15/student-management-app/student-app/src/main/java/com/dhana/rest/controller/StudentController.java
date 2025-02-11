package com.dhana.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/caller")
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private final RestTemplate restTemplate;

    public StudentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${get.receive.url}")
    String receivegetUrl;    //   http://localhost:8080/student/read

    @GetMapping("/get")
    public String getAllStudents() {
        ResponseEntity<String> response
                = restTemplate.exchange(receivegetUrl, HttpMethod.GET, null,String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return response.getBody();
    }
}