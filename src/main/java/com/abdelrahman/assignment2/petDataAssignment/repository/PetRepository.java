package com.abdelrahman.assignment2.petDataAssignment.repository;

import com.abdelrahman.assignment2.petDataAssignment.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
