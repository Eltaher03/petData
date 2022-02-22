package com.abdelrahman.assignment2.petDataAssignment.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "Name")
    private String petName;

    @Column(name = "Kind")
    private String petKind;

    @Column(name = "Gender")
    private String petGender;

    @Column(name = "petVaccination")
    private String petVaccination;

    public Pet() {
    }

    public Pet(long id, @NotBlank(message = "Name is mandatory") String petName, String petKind, String petGender, String petVaccination) {
        this.id = id;
        this.petName = petName;
        this.petKind = petKind;
        this.petGender = petGender;
        this.petVaccination = petVaccination;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetKind() {
        return petKind;
    }

    public void setPetKind(String petKind) {
        this.petKind = petKind;
    }

    public String getPetGender() {
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public String getPetVaccination() {
        return petVaccination;
    }

    public void setPetVaccination(String petVaccination) {
        this.petVaccination = petVaccination;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", petName='" + petName + '\'' +
                ", petKind='" + petKind + '\'' +
                ", petGender='" + petGender + '\'' +
                ", petVaccination='" + petVaccination + '\'' +
                '}';
    }
}
