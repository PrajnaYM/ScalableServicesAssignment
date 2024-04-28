package com.hms.PatientSystem.repository;

import com.hms.PatientSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT q FROM Patient q WHERE q.name LIKE %?1%")
    List<Patient> getContainingPatient(String word);
}