package com.abdelrahman.assignment2.petDataAssignment.repository;

import com.abdelrahman.assignment2.petDataAssignment.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet,Long> {
}
