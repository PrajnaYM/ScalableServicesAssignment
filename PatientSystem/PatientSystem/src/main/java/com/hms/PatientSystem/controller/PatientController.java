package com.hms.PatientSystem.controller;

import com.hms.PatientSystem.model.Patient;
import com.hms.PatientSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getPatients(@RequestParam("search") Optional<String> searchParam){
        return searchParam.map( param->patientRepository.getContainingPatient(param) )
                .orElse(patientRepository.findAll());
    }

    @GetMapping("/patients/{id}" )
    public ResponseEntity<String> readPatient(@PathVariable("id") Long id) {
        return ResponseEntity.of(patientRepository.findById(id).map(Patient::getPatient));
    }

    @GetMapping("/doctors/{id}" )
    public ResponseEntity<String> readDoctor(@PathVariable("doctor_id") Long doctor_id) {
        return ResponseEntity.of(patientRepository.findById(doctor_id).map(Patient::getPatient));
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody String name) {
        Patient q = new Patient();
        q.setPatient(name);
        return patientRepository.save(q);
    }

    @PostMapping("/doctors")
    public Patient addDoctor(@RequestBody Long doctor_id) {
        Patient q = new Patient();
        q.setDoctor_id(doctor_id);
        return patientRepository.save(q);
    }

    @RequestMapping(value="/patients/{id}", method=RequestMethod.DELETE)
    public void deletePatient(@PathVariable(value = "id") Long id) {
        patientRepository.deleteById(id);
    }
}
