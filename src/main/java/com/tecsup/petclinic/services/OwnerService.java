package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exceptions.OwnerNotFoundException;

import java.util.List;

public interface OwnerService {

    OwnerDTO findById(Integer id) throws OwnerNotFoundException;

    List<OwnerDTO> findByLastName(String lastName);

    List<OwnerDTO> findByCity(String city);

    void delete(Integer id) throws OwnerNotFoundException;

    OwnerDTO create(OwnerDTO ownerDTO);

    OwnerDTO update(OwnerDTO ownerDto);

    List<OwnerDTO> findAll();
}
