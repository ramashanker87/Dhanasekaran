package com.dhana.app.service;

import com.dhana.app.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {
    Map<String, Patient> patients = new HashMap<String, Patient>();

    public Patient createPatient(Patient patient) {
        patients.put(patient.getId(), patient);
        return patient;
    }

    public Patient updatePatient(String id, int age) {
        Patient patient = patients.get(id);
        patient.setAge(age);
        return patient;
    }

    public Map<String,Patient> readAllPatient() {
        return patients;
    }

    public void deletePatient(String id) {
        patients.remove(id);
    }

    public Patient readPatientByName(String name) {
        Patient result = patients.get(name);
        return result;
    }
}