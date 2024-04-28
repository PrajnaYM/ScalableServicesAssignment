package com.hms.PatientSystem.model;
import jakarta.persistence.*;

@Entity
@Table(name = "patient_details")
public class Patient {
    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public String getPatient() {
        return name;
    }

    public void setPatient(String quote) {
        this.name = quote;
    }

    @Column(name = "name")
    private String name;

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    private Long doctor_id;
}
