package com.tecsup.petclinic.services;

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
