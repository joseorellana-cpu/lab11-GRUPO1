package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 */
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    // Fetch owner by last name
    Owner findByLastName(String lastName);

    // Fetch owner by city
    Owner findByCity(String city);
}