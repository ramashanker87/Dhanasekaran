package com.dhana.sqs.controller;

import com.dhana.sqs.module.Patient;
import com.dhana.sqs.service.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;
    private final ObjectMapper objectMapper;

    public PatientController(PatientService patientService, ObjectMapper objectMapper) {
        this.patientService = patientService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Patient patient, @RequestHeader("disease") String disease) throws JsonProcessingException {
        Map<String, Object> headers = new HashMap<>();
        String correlationId = UUID.randomUUID().toString();
        headers.put("disease", disease);
        headers.put("correlationId", correlationId);
        String requestMessage = objectMapper.writeValueAsString(patient);
        patientService.sendMessage(requestMessage, headers);
        return disease;
    }
}
