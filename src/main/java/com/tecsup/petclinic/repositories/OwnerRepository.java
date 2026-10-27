package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
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
=======
import java.util.List;

@Repository
public interface OwnerRepository
	extends JpaRepository<Owner, Integer> {

	// Fetch owners by last name
	List<Owner> findByLastName(String lastName);

	// Fetch owners by city
	List<Owner> findByCity(String city);

}
>>>>>>> 6219b72b25686affd14c4fc2177558bcebe5ee9b
