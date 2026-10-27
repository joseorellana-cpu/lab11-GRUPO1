<<<<<<< HEAD
package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * @author jgomezm
 *
 */
@Repository
public interface PetRepository 
	extends JpaRepository<Pet, Integer> {

	// Fetch pets by name
	List<Pet> findByName(String name);

	// Fetch pets by typeId
	List<Pet> findByTypeId(int typeId);

	// Fetch pets by ownerId
	List<Pet> findByOwnerId(int ownerId);

	@Override
	List<Pet> findAll();

}
=======
package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * @author jgomezm
 *
 */
@Repository
public interface PetRepository 
	extends JpaRepository<Pet, Integer> {

	// Fetch pets by name
	List<Pet> findByName(String name);

	// Fetch pets by typeId
	List<Pet> findByTypeId(int typeId);

	// Fetch pets by ownerId
	List<Pet> findByOwnerId(int ownerId);

	@Override
	List<Pet> findAll();

}
>>>>>>> 6219b72b25686affd14c4fc2177558bcebe5ee9b
