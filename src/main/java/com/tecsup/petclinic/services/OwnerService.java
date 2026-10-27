package com.tecsup.petclinic.services;

<<<<<<< HEAD
import com.tecsup.petclinic.entities.Owner;

import java.util.List;

/**
 *
 */
public interface OwnerService {

    Owner createOwner(Owner owner);

    Owner updateOwner(Owner owner);

    void deleteOwner(Integer id);

    Owner findById(Integer id);

    List<Owner> findAll();
}
=======
import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.exceptions.OwnerNotFoundException;

import java.util.List;

public interface OwnerService {

	/**
	 *
	 * @param id
	 * @return
	 * @throws OwnerNotFoundException
	 */
	OwnerDTO findById(Integer id) throws OwnerNotFoundException;

	/**
	 *
	 * @param lastName
	 * @return
	 */
	List<OwnerDTO> findByLastName(String lastName);

	/**
	 *
	 * @param city
	 * @return
	 */
	List<OwnerDTO> findByCity(String city);

}
>>>>>>> 6219b72b25686affd14c4fc2177558bcebe5ee9b
